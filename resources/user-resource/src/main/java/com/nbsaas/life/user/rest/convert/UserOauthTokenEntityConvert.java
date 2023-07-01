package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserOauthToken;
import com.nbsaas.life.user.api.domain.request.UserOauthTokenDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.life.user.data.entity.UserInfo;

/**
* 请求对象转换成实体对象
*/

public class UserOauthTokenEntityConvert  implements Converter<UserOauthToken, UserOauthTokenDataRequest> {

    @Override
    public UserOauthToken convert(UserOauthTokenDataRequest source) {
        UserOauthToken result = new UserOauthToken();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getUser()!=null){
                    UserInfo user =new UserInfo();
                    user.setId(source.getUser());
                    result.setUser(user);
                    }
        return result;
    }
}

