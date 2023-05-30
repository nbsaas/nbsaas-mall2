package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.user.api.domain.simple.UserOauthConfigSimple;
import com.nbsaas.life.user.data.entity.UserOauthConfig;
/**
* 列表对象转换器
*/

public class UserOauthConfigSimpleConvert implements Converter<UserOauthConfigSimple, UserOauthConfig> {




    @Override
    public UserOauthConfigSimple convert(UserOauthConfig source) {
        UserOauthConfigSimple result = new UserOauthConfigSimple();

        result.setLastDate(source.getLastDate());
        result.setAppSecret(source.getAppSecret());
        result.setClassName(source.getClassName());
        result.setAppKey(source.getAppKey());
        result.setId(source.getId());
        result.setState(source.getState());
        result.setModel(source.getModel());
        result.setName(source.getName());
        result.setAddDate(source.getAddDate());


        return result;
    }

}