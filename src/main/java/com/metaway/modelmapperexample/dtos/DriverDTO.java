package com.metaway.modelmapperexample.dtos;

import java.util.ArrayList;
import java.util.List;

public class DriverDTO {

    private Long id;
    private String name;
    private Integer age;

    private List<CarDTO> cars = new ArrayList<>();

    public DriverDTO(){}

    public DriverDTO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }
}
