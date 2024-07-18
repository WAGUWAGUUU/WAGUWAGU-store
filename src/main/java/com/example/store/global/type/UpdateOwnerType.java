package com.example.store.global.type;

import com.example.store.global.exception.OwnerTypeNotFoundException;
import com.example.store.global.exception.StoreTypeNotFoundException;

public enum UpdateOwnerType {
    OWNER_NAME, OWNER_BUSINESS_NUMBER;

    public static UpdateOwnerType stringToOwnerType(String type){
        switch(type) {
            case "name":
                return UpdateOwnerType.OWNER_NAME;
            case "business-number":
                return UpdateOwnerType.OWNER_BUSINESS_NUMBER;
        }
        throw new OwnerTypeNotFoundException();
    }
}
