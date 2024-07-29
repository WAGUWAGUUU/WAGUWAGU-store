package com.example.store.global.type;

import com.example.store.global.exception.StoreTypeNotFoundException;

public enum UpdateStoreType {
    STORE_NAME, STORE_ADDRESS, STORE_OPEN_AT,STORE_CLOSE_AT,STORE_PHONE,STORE_MINIMUM_ORDER_AMOUNT,STORE_INTRODUCTION, STORE_CATEGORY;
    public static UpdateStoreType stringToStoreType(String type){
        switch(type) {
            case "store-name":
                return UpdateStoreType.STORE_NAME;
            case "store-address-string":
                return UpdateStoreType.STORE_ADDRESS;
            case "store-open-at":
                return UpdateStoreType.STORE_OPEN_AT;
            case "store-close-at":
                return UpdateStoreType.STORE_CLOSE_AT;
            case "store-phone":
                return UpdateStoreType.STORE_PHONE;
            case "store-minimum-order-amount":
                return UpdateStoreType.STORE_MINIMUM_ORDER_AMOUNT;
            case "store-introduction":
                return UpdateStoreType.STORE_INTRODUCTION;
            case "store-category":
                return UpdateStoreType.STORE_CATEGORY;
        }
        throw new StoreTypeNotFoundException();
    }
}
