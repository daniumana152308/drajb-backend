package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.CartDetailDto;

public interface ICartDetailService {

    List<CartDetailDto> getAllCartDetails();

    CartDetailDto getCartDetailById(Long id);

    CartDetailDto createCartDetail(CartDetailDto dto);

    CartDetailDto updateCartDetail(Long id, CartDetailDto dto);

    void deleteCartDetail(Long id);
}