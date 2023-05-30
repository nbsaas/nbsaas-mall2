package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.user.api.domain.simple.UserCitySimple;
import com.nbsaas.life.user.data.entity.UserCity;
/**
* 列表对象转换器
*/

public class UserCitySimpleConvert implements Converter<UserCitySimple, UserCity> {




    @Override
    public UserCitySimple convert(UserCity source) {
        UserCitySimple result = new UserCitySimple();

        result.setLastDate(source.getLastDate());
        result.setState(source.getState());
        result.setId(source.getId());
        result.setAddress(source.getAddress());
        result.setName(source.getName());
        result.setAddDate(source.getAddDate());


        return result;
    }

}