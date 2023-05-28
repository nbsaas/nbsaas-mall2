package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.RoleMenu;
import com.nbsaas.life.system.api.domain.simple.RoleMenuSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class RoleMenuSimpleConvert implements Converter<RoleMenuSimple, RoleMenu> {




    @Override
    public RoleMenuSimple convert(RoleMenu source) {
        RoleMenuSimple result = new RoleMenuSimple();

                    result.setLastDate(source.getLastDate());
                    if(source.getMenu()!=null){
                        result.setMenu(source.getMenu().getId());
                    }
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    if(source.getRole()!=null){
                        result.setRole(source.getRole().getId());
                    }


    return result;
  }

}