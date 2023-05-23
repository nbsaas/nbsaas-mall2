package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.RecordLog;
import com.nbsaas.life.system.api.domain.request.RecordLogDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class RecordLogEntityConvert  implements Converter<RecordLog, RecordLogDataRequest> {
@Override
public RecordLog convert(RecordLogDataRequest source) {
RecordLog result = new RecordLog();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

