package com.ucr.store.services;

import java.util.List;

import com.ucr.store.dto.SaleDetailDto;
import com.ucr.store.entities.SaleDetail;

public interface ISaleDetailService {

    List<SaleDetail> getAllSaleDetails();

    SaleDetail getSaleDetailById(Long id);

    SaleDetail createSaleDetail(SaleDetailDto dto);

    SaleDetail updateSaleDetail(Long id, SaleDetailDto dto);

    void deleteSaleDetail(Long id);
}
