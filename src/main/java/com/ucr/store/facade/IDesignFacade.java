package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.DesignDto;
import com.ucr.store.models.DesignResponseModel;

public interface IDesignFacade {

    List<DesignResponseModel> getAll();

    DesignResponseModel getById(Long id);

    DesignResponseModel create(DesignDto dto);

    DesignResponseModel update(
            Long id,
            DesignDto dto);

    void delete(Long id);
}