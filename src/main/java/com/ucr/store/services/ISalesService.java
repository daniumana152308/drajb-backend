package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.SalesDto;

public interface ISalesService {

    List<SalesDto> getAllSales();

    SalesDto getSaleById(Long id);

    SalesDto createSale(SalesDto dto);

    SalesDto updateSale(Long id, SalesDto dto);

    void deleteSale(Long id);
}
