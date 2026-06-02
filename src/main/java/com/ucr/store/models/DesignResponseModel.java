package com.ucr.store.models;

public record DesignResponseModel(
    Long id,
    String name,
    String description,
    String imageUrl
) {}