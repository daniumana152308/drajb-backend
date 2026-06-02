package com.ucr.store.models;

import java.time.LocalDateTime;

public record ShoppingCartResponseModel(
    Long id,
    Long clientId,
    LocalDateTime createdAt,
    String status
) {}