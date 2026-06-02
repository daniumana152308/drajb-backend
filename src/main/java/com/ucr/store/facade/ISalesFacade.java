package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.SalesDto;
import com.ucr.store.models.SalesResponseModel;

public interface ISalesFacade {

    List<SalesResponseModel> getAll();

    SalesResponseModel getById(Long id);

    SalesResponseModel create(SalesDto dto);

    SalesResponseModel update(
            Long id,
            SalesDto dto);

    void delete(Long id);
}