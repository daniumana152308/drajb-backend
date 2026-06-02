package com.ucr.store.models;

import java.math.BigDecimal;

public record SaleDetailResponseModel(
    Long saleId,
    Long productId,
    Integer quantity,
    BigDecimal unitPrice
) {}
