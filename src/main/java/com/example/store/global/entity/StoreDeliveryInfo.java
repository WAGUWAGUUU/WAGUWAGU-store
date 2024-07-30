package com.example.store.global.entity;

import com.example.store.dto.request.StoreDeliveryInfoRequestDto;
import com.example.store.dto.request.UpdateStoreDeliveryInfoRequestDto;
import com.example.store.global.type.UpdateStoreDeliveryInfoType;
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
    private int storeDeliveryInfoState;

    @Column(name = "STORE_DELIVERY_INFO_FEE")
    private int storeDeliveryInfoFee;

    @Column(name = "STORE_DELIVERY_INFO_DISTANCE_END")
    private double storeDeliveryInfoDistanceEnd;

    @JoinColumn (name = "STORE_ID")
    @ManyToOne
    private Store store;

//    public void update(UpdateStoreDeliveryInfoType updateStoreDeliveryInfoType, UpdateStoreDeliveryInfoRequestDto updateStoreDeliveryInfoRequestDto) {
//        switch (updateStoreDeliveryInfoType) {
//            case STORE_DELIVERY_INFO_FEE -> {
//                try {
//                    this.storeDeliveryInfoFee = Integer.parseInt(updateStoreDeliveryInfoRequestDto.value());
//                } catch (NumberFormatException e) {
//                    throw new IllegalArgumentException();
//                }
//            } case STORE_DELIVERY_INFO_DISTANCE_END -> {
//                try {
//                    this.storeDeliveryInfoDistanceEnd = Double.parseDouble(updateStoreDeliveryInfoRequestDto.value());
//                } catch (NumberFormatException e) {
//                    System.out.println("hi");
//                    throw new IllegalArgumentException();
//                }
//            }
//        }
//    }

    public void updateDeliveryInfo(int storeDeliveryInfoFee, double storeDeliveryInfoDistanceEnd) {
        if (!(storeDeliveryInfoFee == this.storeDeliveryInfoFee)) this.storeDeliveryInfoFee = storeDeliveryInfoFee;
        if (!(storeDeliveryInfoDistanceEnd == this.storeDeliveryInfoDistanceEnd)) this.storeDeliveryInfoDistanceEnd = storeDeliveryInfoDistanceEnd;
    }
}
