package com.ucr.store.services;

import java.util.List;

import com.ucr.store.dto.SalesDto;
import com.ucr.store.entities.Sales;
import com.ucr.store.models.ClientSalesSummaryResponseModel;
import com.ucr.store.models.SaleFullDetailResponseModel;

public interface ISalesService {

    List<Sales> getAllSales();

    Sales getSaleById(Long id);

    Sales createSale(SalesDto dto);

    Sales updateSale(Long id, SalesDto dto);

    void deleteSale(Long id);

    List<ClientSalesSummaryResponseModel> getSalesHistoryByClientId(Long clientId);

    SaleFullDetailResponseModel getSaleFullDetail(Long saleId);
}
