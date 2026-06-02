package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.ProductDto;
import com.ucr.store.models.ProductResponseModel;

public interface IProductFacade {

    List<ProductResponseModel> getAll();

    ProductResponseModel getById(Long id);

    ProductResponseModel create(ProductDto dto);

    ProductResponseModel update(
            Long id,
            ProductDto dto);

    void delete(Long id);
}