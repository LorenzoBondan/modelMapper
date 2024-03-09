package com.metaway.modelmapperexample.config;

import com.metaway.modelmapperexample.repositories.CarRepository;
import com.metaway.modelmapperexample.converters.CarsDTOToCarsConverter;
import com.metaway.modelmapperexample.converters.CarsToCarIdsConverter;
import com.metaway.modelmapperexample.dtos.BrandDTO;
import com.metaway.modelmapperexample.dtos.CarDTO;
import com.metaway.modelmapperexample.dtos.DriverDTO;
import com.metaway.modelmapperexample.entities.Brand;
import com.metaway.modelmapperexample.entities.Car;
import com.metaway.modelmapperexample.entities.Driver;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Autowired
    private CarRepository carRepository;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<List<Car>, List<Long>> carToCarId = new CarsToCarIdsConverter();
        modelMapper.typeMap(Brand.class, BrandDTO.class).addMappings(mapper -> mapper.using(carToCarId).map(Brand::getCars, BrandDTO::setCarsIds));

        Converter<List<CarDTO>, List<Car>> carDTOToCar = new CarsDTOToCarsConverter(carRepository);
        modelMapper.typeMap(DriverDTO.class, Driver.class).addMappings(mapper -> mapper.using(carDTOToCar).map(DriverDTO::getCars, Driver::setCars));

        return modelMapper;
    }
}
