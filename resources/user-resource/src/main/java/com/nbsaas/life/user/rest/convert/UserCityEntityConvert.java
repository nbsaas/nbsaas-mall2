package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserCity;
import com.nbsaas.life.user.api.domain.request.UserCityDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class UserCityEntityConvert  implements Converter<UserCity, UserCityDataRequest> {

    @Override
    public UserCity convert(UserCityDataRequest source) {
        UserCity result = new UserCity();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

