package com.example.store.global.type;

public enum StoreCategory {
    피자, 중식, 치킨, 디저트, 양식, 한식, 일식;
    public static StoreCategory stringToCategory(String category){
        switch(category) {
            case "피자":
                return StoreCategory.피자;
            case "중식":
                return StoreCategory.중식;
            case "치킨":
                return StoreCategory.치킨;
            case "디저트":
                return StoreCategory.디저트;
            case "양식":
                return StoreCategory.양식;
            case "한식":
                return StoreCategory.한식;
            case "일식":
                return StoreCategory.일식;
        }
        return null;
    }
}
