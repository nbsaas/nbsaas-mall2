package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.user.api.domain.simple.UserRoleSimple;
import com.nbsaas.life.user.data.entity.UserRole;

/**
 * 列表对象转换器
 */

public class UserRoleSimpleConvert implements Converter
        <UserRoleSimple, UserRole> {


    @Override
    public UserRoleSimple convert(UserRole source) {
        UserRoleSimple result = new UserRoleSimple();

        result.setLastDate(source.getLastDate());
        result.setRoleId(source.getRoleId());
        result.setId(source.getId());
        result.setAddDate(source.getAddDate());


        return result;
    }

}