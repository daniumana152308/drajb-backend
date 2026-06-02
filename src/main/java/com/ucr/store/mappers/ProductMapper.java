package com.ucr.store.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.store.entities.Product;
import com.ucr.store.models.DesignResponseModel;
import com.ucr.store.models.ProductResponseModel;
import com.ucr.store.models.SizeResponseModel;

@Component
public class ProductMapper {

    public ProductResponseModel toResponseModel(Product product) {

        if (product == null) {
            return null;
        }

        DesignResponseModel design = product.getDesign() != null
                ? new DesignResponseModel(
                        product.getDesign().getId(),
                        product.getDesign().getName(),
                        product.getDesign().getDescription(),
                        product.getDesign().getImageUrl())
                : null;

        SizeResponseModel size = product.getSize() != null
                ? new SizeResponseModel(
                        product.getSize().getId(),
                        product.getSize().getLabel(),
                        product.getSize().getDescription())
                : null;

        return new ProductResponseModel(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                design,
                size
        );
    }

    public List<ProductResponseModel> toResponseModelList(
            List<Product> list) {

        return list.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}