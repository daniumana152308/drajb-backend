package com.ucr.store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDto(
    @NotBlank @Email
    String email,

    @NotBlank
    String password
) {}