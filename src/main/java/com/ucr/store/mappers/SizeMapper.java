package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.Size;
import com.ucr.store.models.SizeResponseModel;

@Component
public class SizeMapper {

    public SizeResponseModel toResponseModel(Size s) {

        if (s == null) {
            return null;
        }

        return new SizeResponseModel(
                s.getId(),
                s.getLabel(),
                s.getDescription()
        );
    }

    public List<SizeResponseModel> toResponseModelList(
            List<Size> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}