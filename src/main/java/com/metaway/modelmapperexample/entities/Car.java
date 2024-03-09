package com.metaway.modelmapperexample.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer carYear;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Car(){}

    public Car(Long id, String name, Integer carYear, Brand brand, Driver driver) {
        this.id = id;
        this.name = name;
        this.carYear = carYear;
        this.brand = brand;
        this.driver = driver;
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

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
