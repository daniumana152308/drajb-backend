package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.ClientDto;
import com.ucr.store.entities.Client;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {

        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client not found with id: " + id));
    }

    public Client createClient(ClientDto dto) {

        Client client = new Client();

        client.setFirstName(dto.firstName());
        client.setLastName(dto.lastName());
        client.setEmail(dto.email());
        client.setPhone(dto.phone());
        client.setAddress(dto.address());
        client.setPasswordHash(passwordEncoder.encode(dto.password()));

        return clientRepository.save(client);
    }

    public Client updateClient(Long id, ClientDto dto) {

        Client client = getClientById(id);

        client.setFirstName(dto.firstName());
        client.setLastName(dto.lastName());
        client.setEmail(dto.email());
        client.setPhone(dto.phone());
        client.setAddress(dto.address());
        client.setPasswordHash(passwordEncoder.encode(dto.password()));

        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {

        Client client = getClientById(id);

        clientRepository.delete(client);
    }
}