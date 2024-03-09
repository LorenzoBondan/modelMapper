package com.metaway.modelmapperexample.controllers;

import com.metaway.modelmapperexample.dtos.DriverDTO;
import com.metaway.modelmapperexample.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping
    public ResponseEntity<List<DriverDTO>> findAll(){
        List<DriverDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> findById(@PathVariable Long id){
        DriverDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<DriverDTO> insert(@RequestBody DriverDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> update(@RequestBody DriverDTO dto, @PathVariable Long id){
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }
}
