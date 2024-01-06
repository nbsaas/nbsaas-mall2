package com.nbsaas.boot.shop.api.domain.enums;

public enum ShopState {

    normal,disable;
    @Override
    public String toString() {
        if (name().equals("normal")) {
            return "营业中";
        } else if (name().equals("disable")) {
            return "打烊中";
        }
        return super.toString();
    }
}
