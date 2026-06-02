package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.ProductDto;
import com.ucr.store.facade.IProductFacade;
import com.ucr.store.models.ProductResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductFacade productFacade;

    @GetMapping
    public ResponseEntity<List<ProductResponseModel>> getAll() {
        return ResponseEntity.ok(productFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(productFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseModel> create(
            @Valid @RequestBody ProductDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductDto dto) {

        return ResponseEntity.ok(
                productFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        productFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}