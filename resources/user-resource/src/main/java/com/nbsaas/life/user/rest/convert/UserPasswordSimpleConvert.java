package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserPassword;
import com.nbsaas.life.user.api.domain.simple.UserPasswordSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserPasswordSimpleConvert implements Converter<UserPasswordSimple, UserPassword> {




    @Override
    public UserPasswordSimple convert(UserPassword source) {
        UserPasswordSimple result = new UserPasswordSimple();

                    result.setPassword(source.getPassword());
                    if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                    }
                    result.setLastDate(source.getLastDate());
                    result.setSecurityType(source.getSecurityType());
                    result.setSalt(source.getSalt());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setCheckSize(source.getCheckSize());


    return result;
  }

}