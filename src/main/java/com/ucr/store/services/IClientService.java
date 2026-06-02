package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.ClientDto;

public interface IClientService {

    List<ClientDto> getAllClients();

    ClientDto getClientById(Long id);

    ClientDto createClient(ClientDto dto);

    ClientDto updateClient(Long id, ClientDto dto);

    void deleteClient(Long id);
}
