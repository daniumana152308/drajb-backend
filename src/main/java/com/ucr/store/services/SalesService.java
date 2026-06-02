package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.SalesDto;
import com.ucr.store.entities.Client;
import com.ucr.store.entities.Sales;
import com.ucr.store.entities.ShoppingCart;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.ClientRepository;
import com.ucr.store.repositories.SalesRepository;
import com.ucr.store.repositories.ShoppingCartRepository;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales getSaleById(Long id) {

        return salesRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Sale not found with id: " + id));
    }

    public Sales createSale(SalesDto dto) {

        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client not found"));

        ShoppingCart cart = shoppingCartRepository.findById(dto.cartId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Shopping cart not found"));

        Sales sale = new Sales();

        sale.setClient(client);
        sale.setCart(cart);
        sale.setTotal(dto.total());
        sale.setSaleDate(dto.saleDate());
        sale.setStatus(dto.status());

        return salesRepository.save(sale);
    }

    public Sales updateSale(Long id, SalesDto dto) {

        Sales sale = getSaleById(id);

        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client not found"));

        ShoppingCart cart = shoppingCartRepository.findById(dto.cartId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Shopping cart not found"));

        sale.setClient(client);
        sale.setCart(cart);
        sale.setTotal(dto.total());
        sale.setSaleDate(dto.saleDate());
        sale.setStatus(dto.status());

        return salesRepository.save(sale);
    }

    public void deleteSale(Long id) {

        Sales sale = getSaleById(id);

        salesRepository.delete(sale);
    }
}