package com.ucr.store.models;

public record LoginResponseModel(
    Long id,
    String firstName,
    String lastName,
    String email
) {}