package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.user.api.domain.simple.UserOauthTokenSimple;
import com.nbsaas.life.user.data.entity.UserOauthToken;
/**
* 列表对象转换器
*/

public class UserOauthTokenSimpleConvert implements Converter<UserOauthTokenSimple, UserOauthToken> {




    @Override
    public UserOauthTokenSimple convert(UserOauthToken source) {
        UserOauthTokenSimple result = new UserOauthTokenSimple();

        result.setOpenId(source.getOpenId());
        result.setLastDate(source.getLastDate());
        result.setExpiresTime(source.getExpiresTime());
        result.setId(source.getId());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setRefresh_token(source.getRefresh_token());
        result.setTokenType(source.getTokenType());
        result.setAccess_token(source.getAccess_token());
        result.setLoginSize(source.getLoginSize());
        result.setAddDate(source.getAddDate());


    return result;
  }

}