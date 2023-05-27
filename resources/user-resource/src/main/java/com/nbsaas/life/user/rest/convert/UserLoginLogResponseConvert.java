package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserLoginLog;
import com.nbsaas.life.user.api.domain.response.UserLoginLogResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserLoginLogResponseConvert  implements Converter<UserLoginLogResponse,UserLoginLog> {

    @Override
    public UserLoginLogResponse convert(UserLoginLog source) {
        UserLoginLogResponse  result = new  UserLoginLogResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                    }
                    if(source.getUser()!=null){
                    result.setUserName(source.getUser().getName());
                    }
        return result;
    }

}

