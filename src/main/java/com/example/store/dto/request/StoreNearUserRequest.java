package com.example.store.dto.request;

public record StoreNearUserRequest(
        double longitude, double latitude, String category
) {
}
