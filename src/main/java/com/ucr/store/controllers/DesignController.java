package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.DesignDto;
import com.ucr.store.facade.IDesignFacade;
import com.ucr.store.models.DesignResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/designs")
@CrossOrigin("*")
public class DesignController {

    @Autowired
    private IDesignFacade designFacade;

    @GetMapping
    public ResponseEntity<List<DesignResponseModel>> getAll() {
        return ResponseEntity.ok(designFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(designFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<DesignResponseModel> create(
            @Valid @RequestBody DesignDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(designFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody DesignDto dto) {

        return ResponseEntity.ok(
                designFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        designFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}