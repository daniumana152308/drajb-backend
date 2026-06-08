package com.ucr.store.services;

import java.util.List;

import com.ucr.store.dto.SalesDto;
import com.ucr.store.entities.Sales;

public interface ISalesService {

    List<Sales> getAllSales();

    Sales getSaleById(Long id);

    Sales createSale(SalesDto dto);

    Sales updateSale(Long id, SalesDto dto);

    void deleteSale(Long id);
}
