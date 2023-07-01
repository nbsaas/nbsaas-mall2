package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Role;
import com.nbsaas.life.system.api.domain.response.RoleResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class RoleResponseConvert  implements Converter
<RoleResponse,Role> {

@Override
public RoleResponse convert(Role source) {
RoleResponse  result = new  RoleResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}

}

