package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.ServiceEntity;
import com.ucr.store.models.ServiceEntityResponseModel;

@Component
public class ServiceEntityMapper {

    public ServiceEntityResponseModel toResponseModel(
            ServiceEntity s) {

        if (s == null) {
            return null;
        }

        return new ServiceEntityResponseModel(
                s.getName(),
                s.getDescription(),
                s.getBasePrice()
        );
    }

    public List<ServiceEntityResponseModel> toResponseModelList(
            List<ServiceEntity> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}