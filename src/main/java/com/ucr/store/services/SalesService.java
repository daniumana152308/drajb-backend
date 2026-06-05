package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.SalesDto;
import com.ucr.store.entities.Client;
import com.ucr.store.entities.Sales;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.ClientRepository;
import com.ucr.store.repositories.SalesRepository;

@Service
public class SalesService implements ISalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sales getSaleById(Long id) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Sale not found with id: " + id));
    }

    @Override
    public Sales createSale(SalesDto dto) {
        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        Sales sale = new Sales();
        sale.setClient(client);
        sale.setSaleDate(dto.saleDate());
        sale.setTotalAmount(dto.totalAmount());
        sale.setStatus(dto.status());

        return salesRepository.save(sale);
    }

    @Override
    public Sales updateSale(Long id, SalesDto dto) {
        Sales sale = getSaleById(id);

        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        sale.setClient(client);
        sale.setSaleDate(dto.saleDate());
        sale.setTotalAmount(dto.totalAmount());
        sale.setStatus(dto.status());

        return salesRepository.save(sale);
    }

    @Override
    public void deleteSale(Long id) {
        Sales sale = getSaleById(id);
        salesRepository.delete(sale);
    }
}
