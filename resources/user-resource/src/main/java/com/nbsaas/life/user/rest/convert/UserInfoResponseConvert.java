package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserInfo;
import com.nbsaas.life.user.api.domain.response.UserInfoResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserInfoResponseConvert  implements Converter<UserInfoResponse,UserInfo> {

    @Override
    public UserInfoResponse convert(UserInfo source) {
        UserInfoResponse  result = new  UserInfoResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

