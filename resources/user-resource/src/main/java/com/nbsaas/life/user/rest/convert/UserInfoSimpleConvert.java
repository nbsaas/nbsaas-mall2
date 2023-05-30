package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.user.api.domain.simple.UserInfoSimple;
import com.nbsaas.life.user.data.entity.UserInfo;
/**
* 列表对象转换器
*/

public class UserInfoSimpleConvert implements Converter<UserInfoSimple, UserInfo> {




    @Override
    public UserInfoSimple convert(UserInfo source) {
        UserInfoSimple result = new UserInfoSimple();

        result.setLastDate(source.getLastDate());
        result.setAvatar(source.getAvatar());
        result.setLoginSize(source.getLoginSize());
        result.setName(source.getName());
        result.setId(source.getId());
        result.setStoreState(source.getStoreState());
        result.setPhone(source.getPhone());
        result.setCatalog(source.getCatalog());
        result.setAddDate(source.getAddDate());


        return result;
    }

}