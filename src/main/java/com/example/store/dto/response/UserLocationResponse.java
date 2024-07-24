package com.example.store.dto.response;

import java.time.LocalDateTime;

public record UserLocationResponse(double distanceFromStoreToCustomer, int deliveryFee, LocalDateTime due) {
}
