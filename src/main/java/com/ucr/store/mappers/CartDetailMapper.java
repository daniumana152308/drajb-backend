package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.CartDetail;
import com.ucr.store.models.CartDetailResponseModel;

@Component
public class CartDetailMapper {

    public CartDetailResponseModel toResponseModel(
            CartDetail c) {

        if (c == null) {
            return null;
        }

        return new CartDetailResponseModel(

                c.getCart() != null
                        ? c.getCart().getId()
                        : null,

                c.getProduct() != null
                        ? c.getProduct().getId()
                        : null,

                c.getQuantity(),
                c.getUnitPrice()
        );
    }

    public List<CartDetailResponseModel> toResponseModelList(
            List<CartDetail> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}