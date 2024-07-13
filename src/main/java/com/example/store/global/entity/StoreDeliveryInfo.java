package com.example.store.global.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="STORE_DELIVERY_INFOS")
@Builder
@Setter
public class StoreDeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_DELIVERY_INFO_ID")
    private Long storeDeliveryInfoId;

    @Column(name = "STORE_DELIVERY_INFO_STATE")
    private Long storeDeliveryInfoState;

    @Column(name = "STORE_DELIVERY_INFO_FEE")
    private Long storeDeliveryInfoFee;

    @Column(name = "STORE_DELIVERY_INFO_DISTANCE_END")
    private Long storeDeliveryInfoDistanceEnd;

    @JsonBackReference
    @JoinColumn (name = "STORE_ID")
    @ManyToOne
    private Store store;
}
