package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserOauthToken;
import com.nbsaas.life.user.api.domain.simple.UserOauthTokenSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserOauthTokenSimpleConvert implements Converter<UserOauthTokenSimple, UserOauthToken> {




    @Override
    public UserOauthTokenSimple convert(UserOauthToken source) {
        UserOauthTokenSimple result = new UserOauthTokenSimple();

                    result.setAccess_token(source.getAccess_token());
                    result.setExpiresTime(source.getExpiresTime());
                    if(source.getUser()!=null){
                        result.setUser(source.getUser().getId());
                    }
                    result.setLastDate(source.getLastDate());
                    result.setRefresh_token(source.getRefresh_token());
                    result.setOpenId(source.getOpenId());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setTokenType(source.getTokenType());
                    result.setLoginSize(source.getLoginSize());


    return result;
  }

}