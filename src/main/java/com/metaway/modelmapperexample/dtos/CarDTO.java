package com.metaway.modelmapperexample.dtos;

public class CarDTO {

    private Long id;
    private String name;
    private Integer carYear;
    private String brandName;
    private Long driverId;

    public CarDTO(){}

    public CarDTO(Long id, String name, Integer carYear, String brandName, Long driverId) {
        this.id = id;
        this.name = name;
        this.carYear = carYear;
        this.brandName = brandName;
        this.driverId = driverId;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}
