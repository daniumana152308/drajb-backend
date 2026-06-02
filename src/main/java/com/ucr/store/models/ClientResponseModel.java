package com.ucr.store.models;

public record ClientResponseModel(
    Long id,      
    String firstName,
    String lastName,
    String email,
    String phone,
    String address
) {}