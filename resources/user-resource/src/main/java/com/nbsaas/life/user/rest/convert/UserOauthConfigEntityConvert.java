package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserOauthConfig;
import com.nbsaas.life.user.api.domain.request.UserOauthConfigDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class UserOauthConfigEntityConvert  implements Converter<UserOauthConfig, UserOauthConfigDataRequest> {

    @Override
    public UserOauthConfig convert(UserOauthConfigDataRequest source) {
        UserOauthConfig result = new UserOauthConfig();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

