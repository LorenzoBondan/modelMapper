package com.metaway.modelmapperexample.controllers;

import com.metaway.modelmapperexample.dtos.BrandDTO;
import com.metaway.modelmapperexample.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/brands")
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping
    public ResponseEntity<List<BrandDTO>> findAll(){
        List<BrandDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BrandDTO> findById(@PathVariable Long id){
        BrandDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<BrandDTO> insert(@RequestBody BrandDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BrandDTO> update(@RequestBody BrandDTO dto, @PathVariable Long id){
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }
}
