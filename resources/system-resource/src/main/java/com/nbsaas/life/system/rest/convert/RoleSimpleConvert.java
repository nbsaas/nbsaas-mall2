package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Role;
import com.nbsaas.life.system.api.domain.simple.RoleSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class RoleSimpleConvert implements Converter<RoleSimple, Role> {




@Override
public RoleSimple convert(Role source) {
    RoleSimple result = new RoleSimple();

                result.setName(source.getName());
                result.setRemark(source.getRemark());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}