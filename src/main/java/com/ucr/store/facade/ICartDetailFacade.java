package com.ucr.store.facade;

import java.util.List;

import com.ucr.store.dto.CartDetailDto;
import com.ucr.store.models.CartDetailResponseModel;

public interface ICartDetailFacade {

    List<CartDetailResponseModel> getAll();

    CartDetailResponseModel getById(Long id);

    CartDetailResponseModel create(
            CartDetailDto dto);

    CartDetailResponseModel update(
            Long id,
            CartDetailDto dto);

    void delete(Long id);
}