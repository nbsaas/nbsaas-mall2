package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.ErrorLog;
import com.nbsaas.life.system.api.domain.simple.ErrorLogSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ErrorLogSimpleConvert implements Converter<ErrorLogSimple, ErrorLog> {




@Override
public ErrorLogSimple convert(ErrorLog source) {
    ErrorLogSimple result = new ErrorLogSimple();

                result.setApp(source.getApp());
                result.setNote(source.getNote());
                result.setParam(source.getParam());
                result.setName(source.getName());
                result.setServerName(source.getServerName());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setUrl(source.getUrl());
                result.setLastDate(source.getLastDate());


    return result;
}

}