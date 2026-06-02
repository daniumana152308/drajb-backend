package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.ClientDto;
import com.ucr.store.facade.IClientFacade;
import com.ucr.store.models.ClientResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private IClientFacade clientFacade;

    @GetMapping
    public ResponseEntity<List<ClientResponseModel>> getAll() {
        return ResponseEntity.ok(clientFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(clientFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClientResponseModel> create(
            @Valid @RequestBody ClientDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody ClientDto dto) {

        return ResponseEntity.ok(
                clientFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        clientFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}