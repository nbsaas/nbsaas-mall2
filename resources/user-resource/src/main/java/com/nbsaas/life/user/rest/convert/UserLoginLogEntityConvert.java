package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserLoginLog;
import com.nbsaas.life.user.api.domain.request.UserLoginLogDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.life.user.data.entity.UserInfo;

/**
* 请求对象转换成实体对象
*/

public class UserLoginLogEntityConvert  implements Converter<UserLoginLog, UserLoginLogDataRequest> {
@Override
public UserLoginLog convert(UserLoginLogDataRequest source) {
UserLoginLog result = new UserLoginLog();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
            UserInfo user =new UserInfo();
            user.setId(source.getUser());
            result.setUser(user);
            }
return result;
}
}

