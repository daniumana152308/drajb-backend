package com.ucr.store.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShoppingCartDto(

    @NotNull(message = "Client id is required")
    Long clientId,

    @NotNull(message = "Created date is required")
    LocalDateTime createdAt,

    @NotBlank(message = "Status is required")
    String status

) {}