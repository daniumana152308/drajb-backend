package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.SizeDto;
import com.ucr.store.facade.ISizeFacade;
import com.ucr.store.models.SizeResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sizes")
@CrossOrigin("*")
public class SizeController {

    @Autowired
    private ISizeFacade sizeFacade;

    @GetMapping
    public ResponseEntity<List<SizeResponseModel>> getAll() {

        return ResponseEntity.ok(
                sizeFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SizeResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                sizeFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<SizeResponseModel> create(
            @Valid @RequestBody SizeDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sizeFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SizeResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody SizeDto dto) {

        return ResponseEntity.ok(
                sizeFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        sizeFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}