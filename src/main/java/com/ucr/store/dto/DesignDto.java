package com.ucr.store.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DesignDto(

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name too long")
    String name,

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description too long")
    String description,

    @NotBlank(message = "Image URL is required")
    String imageUrl

) {}