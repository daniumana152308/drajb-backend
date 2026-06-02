package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.CartDetailDto;
import com.ucr.store.facade.ICartDetailFacade;
import com.ucr.store.models.CartDetailResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart-details")
@CrossOrigin("*")
public class CartDetailController {

    @Autowired
    private ICartDetailFacade cartDetailFacade;

    @GetMapping
    public ResponseEntity<List<CartDetailResponseModel>> getAll() {
        return ResponseEntity.ok(cartDetailFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDetailResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                cartDetailFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<CartDetailResponseModel> create(
            @Valid @RequestBody CartDetailDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cartDetailFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDetailResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody CartDetailDto dto) {

        return ResponseEntity.ok(
                cartDetailFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        cartDetailFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}