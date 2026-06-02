package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.BillDto;
import com.ucr.store.facade.IBillFacade;
import com.ucr.store.models.BillResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bills")
@CrossOrigin("*")
public class BillController {

    @Autowired
    private IBillFacade billFacade;

    @GetMapping
    public ResponseEntity<List<BillResponseModel>> getAll() {
        return ResponseEntity.ok(billFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(billFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<BillResponseModel> create(
            @Valid @RequestBody BillDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(billFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody BillDto dto) {

        return ResponseEntity.ok(
                billFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        billFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}