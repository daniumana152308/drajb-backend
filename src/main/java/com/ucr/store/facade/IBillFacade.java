package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.BillDto;
import com.ucr.store.models.BillResponseModel;

public interface IBillFacade {

    List<BillResponseModel> getAll();

    BillResponseModel getById(Long id);

    BillResponseModel create(BillDto dto);

    BillResponseModel update(Long id, BillDto dto);

    void delete(Long id);
}