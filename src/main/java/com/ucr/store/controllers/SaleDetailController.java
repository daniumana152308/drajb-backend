package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.SaleDetailDto;
import com.ucr.store.facade.ISaleDetailFacade;
import com.ucr.store.models.SaleDetailResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sale-details")
@CrossOrigin("*")
public class SaleDetailController {

    @Autowired
    private ISaleDetailFacade saleDetailFacade;

    @GetMapping
    public ResponseEntity<List<SaleDetailResponseModel>> getAll() {
        return ResponseEntity.ok(saleDetailFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDetailResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                saleDetailFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<SaleDetailResponseModel> create(
            @Valid @RequestBody SaleDetailDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saleDetailFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDetailResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody SaleDetailDto dto) {

        return ResponseEntity.ok(
                saleDetailFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        saleDetailFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}