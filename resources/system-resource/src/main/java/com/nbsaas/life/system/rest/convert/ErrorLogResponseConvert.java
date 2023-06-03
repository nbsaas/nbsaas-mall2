package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.response.ErrorLogResponse;
import com.nbsaas.life.system.data.entity.ErrorLog;

/**
 * 实体对象转化成响应对象
 */

public class ErrorLogResponseConvert implements Converter
        <ErrorLogResponse, ErrorLog> {

    @Override
    public ErrorLogResponse convert(ErrorLog source) {
        ErrorLogResponse result = new ErrorLogResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

