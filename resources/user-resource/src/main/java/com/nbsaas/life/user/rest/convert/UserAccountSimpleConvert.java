package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserAccount;
import com.nbsaas.life.user.api.domain.simple.UserAccountSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
 * 列表对象转换器
 */

public class UserAccountSimpleConvert implements Converter
        <UserAccountSimple, UserAccount> {


    @Override
    public UserAccountSimple convert(UserAccount source) {
        UserAccountSimple result = new UserAccountSimple();

        result.setLoginSize(source.getLoginSize());
        result.setId(source.getId());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setUsername(source.getUsername());
        result.setAccountType(source.getAccountType());


        return result;
    }

}