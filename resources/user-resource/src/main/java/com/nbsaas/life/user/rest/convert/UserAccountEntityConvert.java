package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserAccount;
import com.nbsaas.life.user.api.domain.request.UserAccountDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.life.user.data.entity.UserInfo;

/**
* 请求对象转换成实体对象
*/

public class UserAccountEntityConvert  implements Converter<UserAccount, UserAccountDataRequest> {
@Override
public UserAccount convert(UserAccountDataRequest source) {
UserAccount result = new UserAccount();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
                UserInfo user = new UserInfo();
                user.setId(source.getUser());
                result.setUser(user);
            }
return result;
}
}

