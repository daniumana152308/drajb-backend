package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.ShoppingCartDto;
import com.ucr.store.facade.IShoppingCartFacade;
import com.ucr.store.models.ShoppingCartResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/shopping-carts")
@CrossOrigin("*")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartFacade shoppingCartFacade;

    @GetMapping
    public ResponseEntity<List<ShoppingCartResponseModel>> getAll() {

        return ResponseEntity.ok(
                shoppingCartFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                shoppingCartFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<ShoppingCartResponseModel> create(
            @Valid @RequestBody ShoppingCartDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(shoppingCartFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody ShoppingCartDto dto) {

        return ResponseEntity.ok(
                shoppingCartFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        shoppingCartFacade.delete(id);

        return ResponseEntity.noContent().build();
    }
}