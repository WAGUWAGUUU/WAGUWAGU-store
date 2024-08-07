package com.example.store.global.type;

import com.example.store.global.exception.MenuTypeNotFoundException;
import com.example.store.global.exception.StoreDeliveryInfoTypeNotFoundException;
import org.hibernate.sql.Update;

public enum UpdateMenuType {
    MENU_NAME, MENU_INTRODUCTION,MENU_PRICE, MENU_IMAGE;

    public static UpdateMenuType stringToMenuType(String type){
        switch(type) {
            case "name":
                return UpdateMenuType.MENU_NAME;
            case "introduction":
                return UpdateMenuType.MENU_INTRODUCTION;
            case "price":
                return UpdateMenuType.MENU_PRICE;
            case "image":
                return UpdateMenuType.MENU_IMAGE;
        }
        throw new MenuTypeNotFoundException();
    }
}
