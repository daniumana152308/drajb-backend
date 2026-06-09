package com.ucr.store.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleFullDetailResponseModel(
    Long id,
    LocalDateTime saleDate,
    BigDecimal totalAmount,
    String status,
    List<SaleProductItemResponseModel> products,
    ClientInfoResponseModel client
) {}
