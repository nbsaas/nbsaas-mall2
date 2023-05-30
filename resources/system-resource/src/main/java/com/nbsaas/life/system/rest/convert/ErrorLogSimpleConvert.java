package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.ErrorLogSimple;
import com.nbsaas.life.system.data.entity.ErrorLog;
/**
* 列表对象转换器
*/

public class ErrorLogSimpleConvert implements Converter<ErrorLogSimple, ErrorLog> {




    @Override
    public ErrorLogSimple convert(ErrorLog source) {
        ErrorLogSimple result = new ErrorLogSimple();

        result.setLastDate(source.getLastDate());
        result.setParam(source.getParam());
        result.setName(source.getName());
        result.setServerName(source.getServerName());
        result.setId(source.getId());
        result.setApp(source.getApp());
        result.setNote(source.getNote());
        result.setUrl(source.getUrl());
        result.setAddDate(source.getAddDate());


        return result;
    }

}