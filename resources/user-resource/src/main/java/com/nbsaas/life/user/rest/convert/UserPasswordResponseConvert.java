package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserPassword;
import com.nbsaas.life.user.api.domain.response.UserPasswordResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserPasswordResponseConvert  implements Converter
<UserPasswordResponse,UserPassword> {

@Override
public UserPasswordResponse convert(UserPassword source) {
UserPasswordResponse  result = new  UserPasswordResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getSecurityType()!=null){
                result.setSecurityTypeName(String.valueOf(source.getSecurityType()));
            }
            if(source.getUser()!=null){
                result.setUser(source.getUser().getId());
            }
return result;
}

}

