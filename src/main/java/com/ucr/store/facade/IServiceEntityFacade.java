package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.ServiceEntityDto;
import com.ucr.store.models.ServiceEntityResponseModel;

public interface IServiceEntityFacade {

    List<ServiceEntityResponseModel> getAll();

    ServiceEntityResponseModel getById(Long id);

    ServiceEntityResponseModel create(
            ServiceEntityDto dto);

    ServiceEntityResponseModel update(
            Long id,
            ServiceEntityDto dto);

    void delete(Long id);
}