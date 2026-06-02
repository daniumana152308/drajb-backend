package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.Bill;
import com.ucr.store.models.BillResponseModel;

@Component
public class BillMapper {

    public BillResponseModel toResponseModel(Bill b) {

        if (b == null) {
            return null;
        }

        return new BillResponseModel(
                b.getId(),
                b.getSale() != null ? b.getSale().getId() : null,
                b.getIssueDate(),
                b.getShippingDate(),
                b.getTotalAmount(),
                b.getNotes()
        );
    }

    public List<BillResponseModel> toResponseModelList(List<Bill> list) {
        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}