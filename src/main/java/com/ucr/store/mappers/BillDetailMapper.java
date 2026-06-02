package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.BillDetail;
import com.ucr.store.models.BillDetailResponseModel;

@Component
public class BillDetailMapper {

    public BillDetailResponseModel toResponseModel(
            BillDetail entity) {

        if (entity == null) {
            return null;
        }

        return new BillDetailResponseModel(

                entity.getId(),

                entity.getBill() != null
                        ? entity.getBill().getId()
                        : null,

                entity.getService() != null
                        ? entity.getService().getId()
                        : null,

                entity.getPrice()
        );
    }

    public List<BillDetailResponseModel> toResponseModelList(
            List<BillDetail> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}