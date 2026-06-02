package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.SaleDetail;
import com.ucr.store.models.SaleDetailResponseModel;

@Component
public class SaleDetailMapper {

    public SaleDetailResponseModel toResponseModel(
            SaleDetail s) {

        if (s == null) {
            return null;
        }

        return new SaleDetailResponseModel(

                s.getSale() != null
                        ? s.getSale().getId()
                        : null,

                s.getProduct() != null
                        ? s.getProduct().getId()
                        : null,

                s.getQuantity(),
                s.getUnitPrice()
        );
    }

    public List<SaleDetailResponseModel> toResponseModelList(
            List<SaleDetail> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}