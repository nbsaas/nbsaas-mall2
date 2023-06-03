package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.life.user.data.entity.UserInfo;
import com.nbsaas.life.user.data.entity.UserPassword;

/**
* 请求对象转换成实体对象
*/

public class UserPasswordEntityConvert  implements Converter<UserPassword, UserPasswordDataRequest> {
@Override
public UserPassword convert(UserPasswordDataRequest source) {
UserPassword result = new UserPassword();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
                UserInfo user = new UserInfo();
                user.setId(source.getUser());
                result.setUser(user);
            }
return result;
}
}

