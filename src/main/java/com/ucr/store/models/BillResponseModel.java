package com.ucr.store.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BillResponseModel(
    Long id,
    Long saleId,
    LocalDateTime issueDate,
    LocalDate shippingDate,
    BigDecimal totalAmount,
    String notes
) {}