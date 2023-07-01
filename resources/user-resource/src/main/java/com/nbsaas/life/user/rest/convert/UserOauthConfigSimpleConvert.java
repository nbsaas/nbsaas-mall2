package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserOauthConfig;
import com.nbsaas.life.user.api.domain.simple.UserOauthConfigSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserOauthConfigSimpleConvert implements Converter<UserOauthConfigSimple, UserOauthConfig> {




@Override
public UserOauthConfigSimple convert(UserOauthConfig source) {
    UserOauthConfigSimple result = new UserOauthConfigSimple();

                result.setName(source.getName());
                result.setModel(source.getModel());
                result.setAppKey(source.getAppKey());
                result.setAppSecret(source.getAppSecret());
                result.setClassName(source.getClassName());
                result.setState(source.getState());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}