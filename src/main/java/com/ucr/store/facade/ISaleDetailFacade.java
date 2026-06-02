package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.SaleDetailDto;
import com.ucr.store.models.SaleDetailResponseModel;

public interface ISaleDetailFacade {

    List<SaleDetailResponseModel> getAll();

    SaleDetailResponseModel getById(Long id);

    SaleDetailResponseModel create(
            SaleDetailDto dto);

    SaleDetailResponseModel update(
            Long id,
            SaleDetailDto dto);

    void delete(Long id);
}