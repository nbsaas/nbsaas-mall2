package com.nbsaas.life.user.api.domain.enums;

/**
 * 账号类型
 * <p>
 * Created by ada on 2016/12/15.
 */
public enum AccountType {
    phone, email, account;

    @Override
    public String toString() {
        if (name().equals("phone")) {
            return "手机账号";
        } else if (name().equals("email")) {
            return "邮件账号";
        } else if (name().equals("account")) {
            return "普通账号";
        }
        return super.toString();
    }
}
