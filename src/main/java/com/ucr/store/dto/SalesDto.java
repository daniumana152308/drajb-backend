package com.ucr.store.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SalesDto(

    @NotNull(message = "Client id is required")
    Long clientId,

    @NotNull(message = "Cart id is required")
    Long cartId,

    @NotNull(message = "Total is required")
    @Positive(message = "Total must be positive")
    BigDecimal total,

    @NotNull(message = "Sale date is required")
    LocalDateTime saleDate,

    @NotBlank(message = "Status is required")
    String status

) {}