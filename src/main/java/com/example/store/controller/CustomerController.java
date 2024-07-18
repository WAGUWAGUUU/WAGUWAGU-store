package com.example.store.controller;

import com.example.store.dto.kafka.KafkaCustomerDto;
import com.example.store.dto.kafka.KafkaDistanceDto;
import com.example.store.dto.kafka.KafkaStatus;
import com.example.store.dto.request.CustomerRequest;
import com.example.store.dto.request.MenuRequestDto;
import com.example.store.dto.response.OwnerResponse;
import com.example.store.global.entity.Customer;
import com.example.store.global.entity.Owner;
import com.example.store.global.exception.OwnerNotFoundException;
import com.example.store.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createCustomer() {
//        customerService.createCustomer();
//    }

    @GetMapping("/{customerId}")
    public Customer getCustomerByCustomerId(@PathVariable(name = "customerId")Long customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }

}
