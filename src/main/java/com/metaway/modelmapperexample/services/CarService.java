package com.metaway.modelmapperexample.services;

import com.metaway.modelmapperexample.dtos.CarDTO;
import com.metaway.modelmapperexample.entities.Car;
import com.metaway.modelmapperexample.repositories.BrandRepository;
import com.metaway.modelmapperexample.repositories.CarRepository;
import com.metaway.modelmapperexample.repositories.DriverRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<CarDTO> findAll(){
        List<Car> list = repository.findAll();
        return list.stream().map(this::convertToDto).toList();
    }

    @Transactional(readOnly = true)
    public CarDTO findById(Long id){
        Car entity = repository.findById(id).get();
        return convertToDto(entity);
    }

    @Transactional
    public CarDTO insert(CarDTO dto){
        Car entity = new Car();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return convertToDto(entity);
    }

    @Transactional
    public CarDTO update(CarDTO dto, Long id){
        Car entity = repository.findById(id).get();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return convertToDto(entity);
    }

    private CarDTO convertToDto(Car car) {
        return modelMapper.map(car, CarDTO.class);
    }

    private void copyDtoToEntity(CarDTO dto, Car entity){
        entity.setName(dto.getName());
        entity.setCarYear(dto.getCarYear());
        entity.setBrand(brandRepository.findByName(dto.getBrandName()));
        entity.setDriver(driverRepository.findById(dto.getDriverId()).get());
    }
}
