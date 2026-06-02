package com.ucr.store.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.store.dto.SalesDto;
import com.ucr.store.mappers.SalesMapper;
import com.ucr.store.models.SalesResponseModel;
import com.ucr.store.services.SalesService;

@Component
public class SalesFacade implements ISalesFacade {

    @Autowired
    private SalesService salesService;

    @Autowired
    private SalesMapper salesMapper;

    @Override
    public List<SalesResponseModel> getAll() {

        return salesMapper.toResponseModelList(
                salesService.getAllSales());
    }

    @Override
    public SalesResponseModel getById(Long id) {

        return salesMapper.toResponseModel(
                salesService.getSaleById(id));
    }

    @Override
    public SalesResponseModel create(SalesDto dto) {

        return salesMapper.toResponseModel(
                salesService.createSale(dto));
    }

    @Override
    public SalesResponseModel update(
            Long id,
            SalesDto dto) {

        return salesMapper.toResponseModel(
                salesService.updateSale(id, dto));
    }

    @Override
    public void delete(Long id) {

        salesService.deleteSale(id);
    }
}