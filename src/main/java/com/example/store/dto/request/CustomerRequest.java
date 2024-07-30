package com.example.store.dto.request;

public record CustomerRequest(
        Long customerId, double customerLongitude, double customerLatitude
) {
}
