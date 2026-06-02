package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.ShoppingCart;
import com.ucr.store.models.ShoppingCartResponseModel;

@Component
public class ShoppingCartMapper {

    public ShoppingCartResponseModel toResponseModel(
            ShoppingCart c) {

        if (c == null) {
            return null;
        }

        return new ShoppingCartResponseModel(

                c.getId(),

                c.getClient() != null
                        ? c.getClient().getId()
                        : null,

                c.getCreatedAt(),
                c.getStatus()
        );
    }

    public List<ShoppingCartResponseModel> toResponseModelList(
            List<ShoppingCart> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}