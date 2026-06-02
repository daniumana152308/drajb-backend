package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.ShoppingCartDto;
import com.ucr.store.entities.Client;
import com.ucr.store.entities.ShoppingCart;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.ClientRepository;
import com.ucr.store.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<ShoppingCart> getAllCarts() {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart getCartById(Long id) {

        return shoppingCartRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Shopping cart not found with id: " + id));
    }

    public ShoppingCart createCart(ShoppingCartDto dto) {

        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client not found"));

        ShoppingCart cart = new ShoppingCart();

        cart.setClient(client);
        cart.setCreatedAt(dto.createdAt());
        cart.setStatus(dto.status());

        return shoppingCartRepository.save(cart);
    }

    public ShoppingCart updateCart(Long id, ShoppingCartDto dto) {

        ShoppingCart cart = getCartById(id);

        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client not found"));

        cart.setClient(client);
        cart.setCreatedAt(dto.createdAt());
        cart.setStatus(dto.status());

        return shoppingCartRepository.save(cart);
    }

    public void deleteCart(Long id) {

        ShoppingCart cart = getCartById(id);

        shoppingCartRepository.delete(cart);
    }
}