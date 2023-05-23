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

                    result.setServerName(source.getServerName());
                    result.setParam(source.getParam());
                    result.setUrl(source.getUrl());
                    result.setLastDate(source.getLastDate());
                    result.setApp(source.getApp());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setNote(source.getNote());
                    result.setName(source.getName());


    return result;
  }

}