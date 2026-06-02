package com.ucr.store.models;

import java.math.BigDecimal;

public record ProductResponseModel(
    Long id,
    String name,
    String description,
    BigDecimal price,
    DesignResponseModel design,
    SizeResponseModel size
) {}