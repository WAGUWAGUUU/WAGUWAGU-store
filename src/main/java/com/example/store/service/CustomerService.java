package com.example.store.service;

import com.example.store.dto.kafka.KafkaCustomerDto;
import com.example.store.dto.kafka.KafkaDistanceDto;
import com.example.store.dto.kafka.KafkaStatus;
import com.example.store.dto.request.CustomerRequest;
import com.example.store.global.entity.Customer;

public interface CustomerService {
    void createCustomer(KafkaStatus<KafkaCustomerDto> kafkaStatus);

    Customer getCustomerByCustomerId(Long customerId);
}
