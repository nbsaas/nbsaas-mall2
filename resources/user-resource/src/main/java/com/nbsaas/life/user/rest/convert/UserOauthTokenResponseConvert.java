package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserOauthToken;
import com.nbsaas.life.user.api.domain.response.UserOauthTokenResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserOauthTokenResponseConvert  implements Converter
<UserOauthTokenResponse,UserOauthToken> {

@Override
public UserOauthTokenResponse convert(UserOauthToken source) {
UserOauthTokenResponse  result = new  UserOauthTokenResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
                result.setUser(source.getUser().getId());
            }
return result;
}

}

