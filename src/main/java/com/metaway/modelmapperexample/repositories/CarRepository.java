package com.metaway.modelmapperexample.repositories;

import com.metaway.modelmapperexample.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
