package com.metaway.modelmapperexample.repositories;

import com.metaway.modelmapperexample.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByName(String name);
}
