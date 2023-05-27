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

                    result.setModel(source.getModel());
                    result.setAppSecret(source.getAppSecret());
                    result.setLastDate(source.getLastDate());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setState(source.getState());
                    result.setName(source.getName());
                    result.setAppKey(source.getAppKey());
                    result.setClassName(source.getClassName());


    return result;
  }

}