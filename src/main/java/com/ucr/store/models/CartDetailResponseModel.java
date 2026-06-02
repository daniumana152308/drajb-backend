package com.ucr.store.models;

import java.math.BigDecimal;

public record CartDetailResponseModel(

    Long cartId,
    Long productId,
    Integer quantity,
    BigDecimal unitPrice

) {}