package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.RoleSimple;
import com.nbsaas.life.system.data.entity.Role;
/**
* 列表对象转换器
*/

public class RoleSimpleConvert implements Converter<RoleSimple, Role> {




    @Override
    public RoleSimple convert(Role source) {
        RoleSimple result = new RoleSimple();

        result.setLastDate(source.getLastDate());
        result.setName(source.getName());
        result.setId(source.getId());
        result.setRemark(source.getRemark());
        result.setAddDate(source.getAddDate());


    return result;
  }

}