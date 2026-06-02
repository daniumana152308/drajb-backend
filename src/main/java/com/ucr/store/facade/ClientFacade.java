package com.ucr.store.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.store.dto.ClientDto;
import com.ucr.store.mappers.ClientMapper;
import com.ucr.store.models.ClientResponseModel;
import com.ucr.store.services.ClientService;

@Component
public class ClientFacade implements IClientFacade {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<ClientResponseModel> getAll() {

        return clientMapper.toResponseModelList(
                clientService.getAllClients());
    }

    @Override
    public ClientResponseModel getById(Long id) {

        return clientMapper.toResponseModel(
                clientService.getClientById(id));
    }

    @Override
    public ClientResponseModel create(ClientDto dto) {

        return clientMapper.toResponseModel(
                clientService.createClient(dto));
    }

    @Override
    public ClientResponseModel update(
            Long id,
            ClientDto dto) {

        return clientMapper.toResponseModel(
                clientService.updateClient(id, dto));
    }

    @Override
    public void delete(Long id) {

        clientService.deleteClient(id);
    }
}