package com.metaway.modelmapperexample.converters;

import com.metaway.modelmapperexample.entities.Car;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.List;
import java.util.stream.Collectors;

public class CarsToCarIdsConverter implements Converter<List<Car>, List<Long>> {

    @Override
    public List<Long> convert(MappingContext<List<Car>, List<Long>> context){
        return context.getSource().stream().map(Car::getId).collect(Collectors.toList());
    }
}
