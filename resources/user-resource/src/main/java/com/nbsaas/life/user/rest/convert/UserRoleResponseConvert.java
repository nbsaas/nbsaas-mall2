package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.user.api.domain.response.UserRoleResponse;
import com.nbsaas.life.user.data.entity.UserRole;

/**
 * 实体对象转化成响应对象
 */

public class UserRoleResponseConvert implements Converter
        <UserRoleResponse, UserRole> {

    @Override
    public UserRoleResponse convert(UserRole source) {
        UserRoleResponse result = new UserRoleResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

