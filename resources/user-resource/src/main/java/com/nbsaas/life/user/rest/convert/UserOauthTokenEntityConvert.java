package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.user.api.domain.request.UserOauthTokenDataRequest;
import com.nbsaas.life.user.data.entity.UserInfo;
import com.nbsaas.life.user.data.entity.UserOauthToken;

/**
* 请求对象转换成实体对象
*/

public class UserOauthTokenEntityConvert  implements Converter<UserOauthToken, UserOauthTokenDataRequest> {
@Override
public UserOauthToken convert(UserOauthTokenDataRequest source) {
UserOauthToken result = new UserOauthToken();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
                UserInfo user = new UserInfo();
                user.setId(source.getUser());
                result.setUser(user);
            }
return result;
}
}

