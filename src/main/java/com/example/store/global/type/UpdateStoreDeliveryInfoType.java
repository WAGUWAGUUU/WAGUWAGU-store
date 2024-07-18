package com.example.store.global.type;

import com.example.store.global.exception.StoreDeliveryInfoTypeNotFoundException;
import com.example.store.global.exception.StoreTypeNotFoundException;

public enum UpdateStoreDeliveryInfoType {
    STORE_DELIVERY_INFO_FEE, STORE_DELIVERY_INFO_DISTANCE_END;

    public static UpdateStoreDeliveryInfoType stringToStoreDeliveryInfoType(String type){
        switch(type) {
            case "fee":
                return UpdateStoreDeliveryInfoType.STORE_DELIVERY_INFO_FEE;
            case "distance-end":
                return UpdateStoreDeliveryInfoType.STORE_DELIVERY_INFO_DISTANCE_END;
        }
        throw new StoreDeliveryInfoTypeNotFoundException();
    }
}
