package com.ucr.store.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ServiceEntityDto(

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name too long")
    String name,

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description too long")
    String description,

    @NotNull(message = "Base price is required")
    @Positive(message = "Base price must be positive")
    BigDecimal basePrice

) {}