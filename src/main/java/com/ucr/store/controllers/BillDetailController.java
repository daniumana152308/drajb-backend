package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.BillDetailDto;
import com.ucr.store.facade.IBillDetailFacade;
import com.ucr.store.models.BillDetailResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bill-details")
@CrossOrigin("*")
public class BillDetailController {

    @Autowired
    private IBillDetailFacade billDetailFacade;

    @GetMapping
    public ResponseEntity<List<BillDetailResponseModel>> getAll() {
        return ResponseEntity.ok(billDetailFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDetailResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                billDetailFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<BillDetailResponseModel> create(
            @Valid @RequestBody BillDetailDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(billDetailFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillDetailResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody BillDetailDto dto) {

        return ResponseEntity.ok(
                billDetailFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        billDetailFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}