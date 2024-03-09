package com.metaway.modelmapperexample.repositories;

import com.metaway.modelmapperexample.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
