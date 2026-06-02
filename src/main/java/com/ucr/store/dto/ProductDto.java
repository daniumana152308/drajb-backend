package com.ucr.store.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductDto(

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name too long")
    String name,

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description too long")
    String description,

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    BigDecimal price,

    @NotNull(message = "Design id is required")
    Long designId,

    @NotNull(message = "Size id is required")
    Long sizeId

) {}