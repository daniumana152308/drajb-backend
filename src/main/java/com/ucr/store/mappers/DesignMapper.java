package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.Design;
import com.ucr.store.models.DesignResponseModel;

@Component
public class DesignMapper {

    public DesignResponseModel toResponseModel(Design d) {

        if (d == null) {
            return null;
        }

        return new DesignResponseModel(
                d.getId(),
                d.getName(),
                d.getDescription(),
                d.getImageUrl()
        );
    }

    public List<DesignResponseModel> toResponseModelList(
            List<Design> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}