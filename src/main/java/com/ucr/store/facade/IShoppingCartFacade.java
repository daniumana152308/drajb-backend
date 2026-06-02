package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.ShoppingCartDto;
import com.ucr.store.models.ShoppingCartResponseModel;

public interface IShoppingCartFacade {

    List<ShoppingCartResponseModel> getAll();

    ShoppingCartResponseModel getById(Long id);

    ShoppingCartResponseModel create(
            ShoppingCartDto dto);

    ShoppingCartResponseModel update(
            Long id,
            ShoppingCartDto dto);

    void delete(Long id);
}