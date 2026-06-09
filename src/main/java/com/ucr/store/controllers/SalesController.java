package com.ucr.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucr.store.dto.SalesDto;
import com.ucr.store.facade.ISalesFacade;
import com.ucr.store.models.ClientSalesSummaryResponseModel;
import com.ucr.store.models.SaleFullDetailResponseModel;
import com.ucr.store.models.SalesResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sales")
@CrossOrigin("*")
public class SalesController {

    @Autowired
    private ISalesFacade salesFacade;

    @GetMapping
    public ResponseEntity<List<SalesResponseModel>> getAll() {
        return ResponseEntity.ok(salesFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesResponseModel> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(salesFacade.getById(id));
    }

    @PostMapping
    public ResponseEntity<SalesResponseModel> create(
            @Valid @RequestBody SalesDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salesFacade.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesResponseModel> update(
            @PathVariable Long id,
            @Valid @RequestBody SalesDto dto) {

        return ResponseEntity.ok(salesFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        salesFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ClientSalesSummaryResponseModel>> getClientSalesHistory(
            @PathVariable Long clientId) {

        return ResponseEntity.ok(salesFacade.getClientSalesHistory(clientId));
    }

    @GetMapping("/{saleId}/details")
    public ResponseEntity<SaleFullDetailResponseModel> getSaleFullDetail(
            @PathVariable Long saleId) {

        return ResponseEntity.ok(salesFacade.getSaleFullDetail(saleId));
    }
}
