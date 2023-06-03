package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.response.RecordLogResponse;
import com.nbsaas.life.system.data.entity.RecordLog;

/**
 * 实体对象转化成响应对象
 */

public class RecordLogResponseConvert implements Converter
        <RecordLogResponse, RecordLog> {

    @Override
    public RecordLogResponse convert(RecordLog source) {
        RecordLogResponse result = new RecordLogResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

