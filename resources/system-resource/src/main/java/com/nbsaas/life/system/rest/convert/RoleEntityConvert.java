package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Role;
import com.nbsaas.life.system.api.domain.request.RoleDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class RoleEntityConvert  implements Converter<Role, RoleDataRequest> {
@Override
public Role convert(RoleDataRequest source) {
Role result = new Role();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

