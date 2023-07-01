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
                result.setSalt(source.getSalt());
                if(source.getSecurityType()!=null){
                    result.setSecurityTypeName(String.valueOf(source.getSecurityType()));
                }
                result.setSecurityType(source.getSecurityType());
                result.setCheckSize(source.getCheckSize());
                result.setId(source.getId());
                if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                }
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}