package com.example.store.global.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="CUSTOMERS")
@Builder
public class Customer {
    @Id
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "CUSTOMER_ADDRESS_X")
    double customerAddressX;

    @Column(name = "CUSTOMER_ADDRESS_Y")
    double customerAddressY;
}
