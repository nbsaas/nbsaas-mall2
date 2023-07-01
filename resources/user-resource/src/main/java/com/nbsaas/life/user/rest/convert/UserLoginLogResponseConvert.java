package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserLoginLog;
import com.nbsaas.life.user.api.domain.response.UserLoginLogResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserLoginLogResponseConvert  implements Converter
<UserLoginLogResponse,UserLoginLog> {

@Override
public UserLoginLogResponse convert(UserLoginLog source) {
UserLoginLogResponse  result = new  UserLoginLogResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getStoreState()!=null){
                result.setStoreStateName(String.valueOf(source.getStoreState()));
            }
            if(source.getState()!=null){
                result.setStateName(String.valueOf(source.getState()));
            }
            if(source.getUser()!=null){
                result.setUserName(source.getUser().getName());
            }
            if(source.getUser()!=null){
                result.setUser(source.getUser().getId());
            }
return result;
}

}

