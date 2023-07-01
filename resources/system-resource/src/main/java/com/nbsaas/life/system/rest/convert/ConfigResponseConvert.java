package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Config;
import com.nbsaas.life.system.api.domain.response.ConfigResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class ConfigResponseConvert  implements Converter
<ConfigResponse,Config> {

@Override
public ConfigResponse convert(Config source) {
ConfigResponse  result = new  ConfigResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}

}

