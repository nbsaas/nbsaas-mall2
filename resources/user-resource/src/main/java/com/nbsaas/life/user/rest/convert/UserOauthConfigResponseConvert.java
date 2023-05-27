package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserOauthConfig;
import com.nbsaas.life.user.api.domain.response.UserOauthConfigResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserOauthConfigResponseConvert  implements Converter<UserOauthConfigResponse,UserOauthConfig> {

    @Override
    public UserOauthConfigResponse convert(UserOauthConfig source) {
        UserOauthConfigResponse  result = new  UserOauthConfigResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

