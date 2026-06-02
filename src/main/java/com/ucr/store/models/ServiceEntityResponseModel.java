package com.ucr.store.models;

import java.math.BigDecimal;

public record ServiceEntityResponseModel(
    String name,
    String description,
    BigDecimal basePrice
) {}
