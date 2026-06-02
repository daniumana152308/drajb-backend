package com.ucr.store.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BillDto(

    @NotNull(message = "Sale id is required")
    Long saleId,

    @NotNull(message = "Issue date is required")
    LocalDateTime issueDate,

    LocalDate shippingDate,

    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be positive")
    BigDecimal totalAmount,

    String notes

) {}