package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserRole;
import com.nbsaas.life.user.api.domain.request.UserRoleDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class UserRoleEntityConvert  implements Converter<UserRole, UserRoleDataRequest> {

    @Override
    public UserRole convert(UserRoleDataRequest source) {
        UserRole result = new UserRole();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

