package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.ClientDto;
import com.ucr.store.models.ClientResponseModel;

public interface IClientFacade {

    List<ClientResponseModel> getAll();

    ClientResponseModel getById(Long id);

    ClientResponseModel create(ClientDto dto);

    ClientResponseModel update(
            Long id,
            ClientDto dto);

    void delete(Long id);
}