package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.RoleMenuSimple;
import com.nbsaas.life.system.data.entity.RoleMenu;

/**
 * 列表对象转换器
 */

public class RoleMenuSimpleConvert implements Converter
        <RoleMenuSimple, RoleMenu> {


    @Override
    public RoleMenuSimple convert(RoleMenu source) {
        RoleMenuSimple result = new RoleMenuSimple();

        result.setLastDate(source.getLastDate());
        result.setId(source.getId());
        if (source.getMenu() != null) {
            result.setMenu(source.getMenu().getId());
        }
        if (source.getRole() != null) {
            result.setRole(source.getRole().getId());
        }
        result.setAddDate(source.getAddDate());


        return result;
    }

}