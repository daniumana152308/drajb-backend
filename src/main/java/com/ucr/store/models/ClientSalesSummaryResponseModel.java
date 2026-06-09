package com.ucr.store.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ClientSalesSummaryResponseModel(
    Long id,
    LocalDateTime saleDate,
    BigDecimal totalAmount,
    String status,
    Long productCount
) {}
