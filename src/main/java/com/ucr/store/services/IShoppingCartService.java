package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.ShoppingCartDto;

public interface IShoppingCartService {

    List<ShoppingCartDto> getAllCarts();

    ShoppingCartDto getCartById(Long id);

    ShoppingCartDto createCart(ShoppingCartDto dto);

    ShoppingCartDto updateCart(Long id, ShoppingCartDto dto);

    void deleteCart(Long id);
}