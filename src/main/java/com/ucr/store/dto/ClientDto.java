package com.ucr.store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientDto(

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name too long")
    String firstName,

    @NotBlank(message = "Last name is required")
    @Size(max = 100, message = "Last name too long")
    String lastName,

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    String email,

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    String password,

    @NotBlank(message = "Phone is required")
    @Size(max = 20, message = "Phone too long")
    String phone,

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address too long")
    String address

) {}