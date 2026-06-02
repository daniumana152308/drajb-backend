package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.SaleDetailDto;

public interface ISaleDetailService {

    List<SaleDetailDto> getAllSaleDetails();

    SaleDetailDto getSaleDetailById(Long id);

    SaleDetailDto createSaleDetail(SaleDetailDto dto);

    SaleDetailDto updateSaleDetail(Long id, SaleDetailDto dto);

    void deleteSaleDetail(Long id);
}
