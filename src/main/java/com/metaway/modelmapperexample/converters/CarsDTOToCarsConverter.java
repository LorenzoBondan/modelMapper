package com.metaway.modelmapperexample.converters;

import com.metaway.modelmapperexample.dtos.CarDTO;
import com.metaway.modelmapperexample.entities.Car;
import com.metaway.modelmapperexample.repositories.CarRepository;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarsDTOToCarsConverter implements Converter<List<CarDTO>, List<Car>> {

    private final CarRepository carRepository;

    @Autowired
    public CarsDTOToCarsConverter(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    @Override
    public List<Car> convert(MappingContext<List<CarDTO>, List<Car>> context){
        return context.getSource().stream().map(carDto -> carRepository.findById(carDto.getId()).get()).collect(Collectors.toList());
    }
}
