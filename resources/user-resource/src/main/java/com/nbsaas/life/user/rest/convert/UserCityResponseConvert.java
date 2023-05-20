package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserCity;
import com.nbsaas.life.user.api.domain.response.UserCityResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserCityResponseConvert  implements Converter<UserCityResponse,UserCity> {

    @Override
    public UserCityResponse convert(UserCity source) {
        UserCityResponse  result = new  UserCityResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

