package com.ucr.store.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CartDetailDto(

    @NotNull(message = "Cart id is required")
    Long cartId,

    @NotNull(message = "Product id is required")
    Long productId,

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    Integer quantity,

    @NotNull(message = "Unit price is required")
    @Positive(message = "Unit price must be positive")
    BigDecimal unitPrice

) {}