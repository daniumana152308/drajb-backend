package com.ucr.store.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.store.dto.SaleDetailDto;
import com.ucr.store.mappers.SaleDetailMapper;
import com.ucr.store.models.SaleDetailResponseModel;
import com.ucr.store.services.SaleDetailService;

@Component
public class SaleDetailFacade implements ISaleDetailFacade {

    @Autowired
    private SaleDetailService saleDetailService;

    @Autowired
    private SaleDetailMapper saleDetailMapper;

    @Override
    public List<SaleDetailResponseModel> getAll() {

        return saleDetailMapper.toResponseModelList(
                saleDetailService.getAllSaleDetails());
    }

    @Override
    public SaleDetailResponseModel getById(Long id) {

        return saleDetailMapper.toResponseModel(
                saleDetailService.getSaleDetailById(id));
    }

    @Override
    public SaleDetailResponseModel create(
            SaleDetailDto dto) {

        return saleDetailMapper.toResponseModel(
                saleDetailService.createSaleDetail(dto));
    }

    @Override
    public SaleDetailResponseModel update(
            Long id,
            SaleDetailDto dto) {

        return saleDetailMapper.toResponseModel(
                saleDetailService.updateSaleDetail(id, dto));
    }

    @Override
    public void delete(Long id) {

        saleDetailService.deleteSaleDetail(id);
    }
}