package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.BillDetailDto;
import com.ucr.store.models.BillDetailResponseModel;

public interface IBillDetailFacade {

    List<BillDetailResponseModel> getAll();

    BillDetailResponseModel getById(Long id);

    BillDetailResponseModel create(BillDetailDto dto);

    BillDetailResponseModel update(
            Long id,
            BillDetailDto dto);

    void delete(Long id);
}