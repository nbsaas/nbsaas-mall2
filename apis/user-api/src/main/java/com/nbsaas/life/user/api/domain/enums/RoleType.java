package com.nbsaas.life.user.api.domain.enums;

public enum RoleType {
    system, custom;

    @Override
    public String toString() {
        if (name().equals("system")) {
            return "系统";
        } else if (name().equals("custom")) {
            return "自定义";
        }
        return super.toString();
    }
}
