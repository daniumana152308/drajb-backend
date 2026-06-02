package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.SizeDto;
import com.ucr.store.models.SizeResponseModel;

public interface ISizeFacade {

    List<SizeResponseModel> getAll();

    SizeResponseModel getById(Long id);

    SizeResponseModel create(SizeDto dto);

    SizeResponseModel update(
            Long id,
            SizeDto dto);

    void delete(Long id);
}