package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.Sales;
import com.ucr.store.models.SalesResponseModel;

@Component
public class SalesMapper {

    public SalesResponseModel toResponseModel(Sales s) {

        if (s == null) {
            return null;
        }

        return new SalesResponseModel(
                s.getId(),
                s.getClient() != null ? s.getClient().getId() : null,
                s.getCart() != null ? s.getCart().getId() : null,
                s.getTotal(),
                s.getSaleDate(),
                s.getStatus()
        );
    }

    public List<SalesResponseModel> toResponseModelList(List<Sales> list) {
        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}