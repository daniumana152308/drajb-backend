package com.ucr.store.models;

import java.math.BigDecimal;

public record BillDetailResponseModel(
    Long id,
    Long billId,
    Long serviceId,
    BigDecimal price
) {}
