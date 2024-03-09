package com.metaway.modelmapperexample.services;

import com.metaway.modelmapperexample.dtos.CarDTO;
import com.metaway.modelmapperexample.dtos.DriverDTO;
import com.metaway.modelmapperexample.entities.Car;
import com.metaway.modelmapperexample.entities.Driver;
import com.metaway.modelmapperexample.repositories.CarRepository;
import com.metaway.modelmapperexample.repositories.DriverRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<DriverDTO> findAll(){
        List<Driver> list = repository.findAll();
        return list.stream().map(this::convertToDto).toList();
    }

    @Transactional(readOnly = true)
    public DriverDTO findById(Long id){
        Driver entity = repository.findById(id).get();
        return convertToDto(entity);
    }

    @Transactional
    public DriverDTO insert(DriverDTO dto){
        Driver entity = convertToEntity(dto);
        //copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return convertToDto(entity);
    }

    @Transactional
    public DriverDTO update(DriverDTO dto, Long id){
        Driver entity = repository.findById(id).get();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return convertToDto(entity);
    }

    private DriverDTO convertToDto(Driver driver) {
        return modelMapper.map(driver, DriverDTO.class);
    }

    private Driver convertToEntity(DriverDTO dto) { return modelMapper.map(dto, Driver.class); }

    public void copyDtoToEntity(DriverDTO dto, Driver entity){
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());

        entity.getCars().clear();
        for(CarDTO carDTO : dto.getCars()){
            Car car = carRepository.findById(carDTO.getId()).get();
            entity.getCars().add(car);
        }
    }
}
