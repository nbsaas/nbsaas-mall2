package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.user.api.domain.simple.UserPasswordSimple;
import com.nbsaas.life.user.data.entity.UserPassword;
/**
* 列表对象转换器
*/

public class UserPasswordSimpleConvert implements Converter<UserPasswordSimple, UserPassword> {




    @Override
    public UserPasswordSimple convert(UserPassword source) {
        UserPasswordSimple result = new UserPasswordSimple();

        result.setSecurityType(source.getSecurityType());
        result.setLastDate(source.getLastDate());
        result.setSalt(source.getSalt());
        result.setId(source.getId());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setPassword(source.getPassword());
        result.setCheckSize(source.getCheckSize());
        result.setAddDate(source.getAddDate());


        return result;
    }

}