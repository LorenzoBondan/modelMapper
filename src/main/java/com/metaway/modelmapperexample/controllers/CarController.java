package com.metaway.modelmapperexample.controllers;

import com.metaway.modelmapperexample.dtos.CarDTO;
import com.metaway.modelmapperexample.entities.Car;
import com.metaway.modelmapperexample.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping
    public ResponseEntity<List<CarDTO>> findAll(){
        List<CarDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable Long id){
        CarDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CarDTO> insert(@RequestBody CarDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CarDTO> update(@RequestBody CarDTO dto, @PathVariable Long id){
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }
}
