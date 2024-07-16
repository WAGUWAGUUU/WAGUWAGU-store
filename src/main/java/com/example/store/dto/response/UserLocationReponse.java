package com.example.store.dto.response;

import java.time.LocalDateTime;

public record UserLocationReponse(double distanceFromStoreToCustomer, int deliveryFee, LocalDateTime due) {
}
