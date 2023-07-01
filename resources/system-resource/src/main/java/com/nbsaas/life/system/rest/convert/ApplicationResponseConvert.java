package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Application;
import com.nbsaas.life.system.api.domain.response.ApplicationResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class ApplicationResponseConvert  implements Converter
<ApplicationResponse,Application> {

@Override
public ApplicationResponse convert(Application source) {
ApplicationResponse  result = new  ApplicationResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}

}

