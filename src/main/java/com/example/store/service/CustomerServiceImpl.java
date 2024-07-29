package com.example.store.service;

import com.example.store.dto.kafka.KafkaCustomerDto;
import com.example.store.dto.kafka.KafkaDistanceDto;
import com.example.store.dto.kafka.KafkaStatus;
import com.example.store.dto.request.CustomerRequest;
import com.example.store.global.entity.Customer;
import com.example.store.global.exception.CustomerNotFoundException;
import com.example.store.global.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    @KafkaListener(topics = "customer-info-request-to-store-topic")
    @Override
    @Transactional
    public void createCustomer(KafkaStatus<KafkaCustomerDto> kafkaStatus) {
        if(kafkaStatus.status().equals("customer_info_to_store")) {
            CustomerRequest customerRequest = new CustomerRequest(kafkaStatus.data().customerId(), kafkaStatus.data().longitude(), kafkaStatus.data().latitude());
            Customer customer = new Customer(customerRequest.customerId(), customerRequest.customerLongitude(), customerRequest.customerLatitude());
            customerRepository.save(customer);
        }
    }

    @Override
    public Customer getCustomerByCustomerId(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }
}
