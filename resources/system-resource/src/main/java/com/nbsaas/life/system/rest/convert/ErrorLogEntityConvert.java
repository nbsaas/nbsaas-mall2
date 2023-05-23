package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.ErrorLog;
import com.nbsaas.life.system.api.domain.request.ErrorLogDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ErrorLogEntityConvert  implements Converter<ErrorLog, ErrorLogDataRequest> {
@Override
public ErrorLog convert(ErrorLogDataRequest source) {
ErrorLog result = new ErrorLog();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

