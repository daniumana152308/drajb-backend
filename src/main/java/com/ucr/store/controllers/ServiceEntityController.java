package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.ServiceEntityDto;
import com.ucr.store.facade.IServiceEntityFacade;
import com.ucr.store.models.ServiceEntityResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/services")
@CrossOrigin("*")
public class ServiceEntityController {

    @Autowired
    private IServiceEntityFacade serviceEntityFacade;

    @GetMapping
    public ResponseEntity<List<ServiceEntityResponseModel>> getAll() {

        return ResponseEntity.ok(
                serviceEntityFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntityResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                serviceEntityFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceEntityResponseModel> create(
            @Valid @RequestBody ServiceEntityDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(serviceEntityFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntityResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody ServiceEntityDto dto) {

        return ResponseEntity.ok(
                serviceEntityFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        serviceEntityFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}