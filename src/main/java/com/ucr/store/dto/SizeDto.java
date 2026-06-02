package com.ucr.store.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SizeDto(

    @NotBlank(message = "Label is required")
    @Size(max = 50, message = "Label too long")
    String label,

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description too long")
    String description

) {}