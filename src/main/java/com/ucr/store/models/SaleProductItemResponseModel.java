package com.ucr.store.models;

import java.math.BigDecimal;

public record SaleProductItemResponseModel(
    String productName,
    String design,
    String size,
    Integer quantity,
    BigDecimal unitPrice,
    BigDecimal subtotal
) {}
