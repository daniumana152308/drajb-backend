package com.ucr.store.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BillDetailDto(

        @NotNull(message = "Bill id is required")
        Long billId,

        @NotNull(message = "Service id is required")
        Long serviceId,

        @NotNull(message = "Price is required")
        @Positive(message = "Price must be positive")
        BigDecimal price
) {
}