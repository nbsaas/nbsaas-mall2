package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.RecordLogSimple;
import com.nbsaas.life.system.data.entity.RecordLog;

/**
 * 列表对象转换器
 */

public class RecordLogSimpleConvert implements Converter
        <RecordLogSimple, RecordLog> {


    @Override
    public RecordLogSimple convert(RecordLog source) {
        RecordLogSimple result = new RecordLogSimple();

        result.setCreateDate(source.getCreateDate());
        result.setLastDate(source.getLastDate());
        result.setCreateName(source.getCreateName());
        result.setId(source.getId());
        result.setApp(source.getApp());
        result.setCreateUser(source.getCreateUser());
        result.setData(source.getData());
        result.setTitle(source.getTitle());
        result.setIp(source.getIp());
        result.setAddDate(source.getAddDate());


        return result;
    }

}