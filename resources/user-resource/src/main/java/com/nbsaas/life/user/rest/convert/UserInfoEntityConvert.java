package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserInfo;
import com.nbsaas.life.user.api.domain.request.UserInfoDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class UserInfoEntityConvert  implements Converter<UserInfo, UserInfoDataRequest> {

    @Override
    public UserInfo convert(UserInfoDataRequest source) {
        UserInfo result = new UserInfo();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

