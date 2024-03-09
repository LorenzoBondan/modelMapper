package com.metaway.modelmapperexample.services;

import com.metaway.modelmapperexample.dtos.BrandDTO;
import com.metaway.modelmapperexample.entities.Brand;
import com.metaway.modelmapperexample.entities.Car;
import com.metaway.modelmapperexample.repositories.BrandRepository;
import com.metaway.modelmapperexample.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<BrandDTO> findAll(){
        List<Brand> list = repository.findAll();
        return list.stream().map(this::convertToDto).toList();
    }

    @Transactional(readOnly = true)
    public BrandDTO findById(Long id){
        Brand entity = repository.findById(id).get();
        return convertToDto(entity);
    }

    @Transactional
    public BrandDTO insert(BrandDTO dto){
        Brand entity = new Brand();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return convertToDto(entity);
    }

    @Transactional
    public BrandDTO update(BrandDTO dto, Long id){
        Brand entity = repository.findById(id).get();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return convertToDto(entity);
    }

    private BrandDTO convertToDto(Brand brand) {
        return modelMapper.map(brand, BrandDTO.class);
    }

    private void copyDtoToEntity(BrandDTO dto, Brand entity){
        entity.setName(dto.getName());

        entity.getCars().clear();
        for(Long carId : dto.getCarsIds()){
            Car car = carRepository.findById(carId).get();
            entity.getCars().add(car);
        }
    }
}
