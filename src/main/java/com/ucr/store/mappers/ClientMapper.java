package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.Client;
import com.ucr.store.models.ClientResponseModel;

@Component
public class ClientMapper {

    public ClientResponseModel toResponseModel(Client c) {

        if (c == null) {
            return null;
        }

        return new ClientResponseModel(
                c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getEmail(),
                c.getPhone(),
                c.getAddress()
        );
    }

    public List<ClientResponseModel> toResponseModelList(
            List<Client> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}