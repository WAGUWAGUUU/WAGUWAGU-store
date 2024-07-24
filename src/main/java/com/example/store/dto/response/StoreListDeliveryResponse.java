package com.example.store.dto.response;

import java.time.LocalDateTime;

public record StoreListDeliveryResponse(double distanceFromStoreToCustomer, int deliveryFee) {
}