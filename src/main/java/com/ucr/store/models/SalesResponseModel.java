package com.ucr.store.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SalesResponseModel(
    Long id,
    Long clientId,
    Long cartId,
    BigDecimal total,
    LocalDateTime saleDate,
    String status
) {}