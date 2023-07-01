package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.RecordLog;
import com.nbsaas.life.system.api.domain.simple.RecordLogSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class RecordLogSimpleConvert implements Converter<RecordLogSimple, RecordLog> {




@Override
public RecordLogSimple convert(RecordLog source) {
    RecordLogSimple result = new RecordLogSimple();

                result.setApp(source.getApp());
                result.setData(source.getData());
                result.setIp(source.getIp());
                result.setCreateUser(source.getCreateUser());
                result.setId(source.getId());
                result.setTitle(source.getTitle());
                result.setAddDate(source.getAddDate());
                result.setCreateName(source.getCreateName());
                result.setCreateDate(source.getCreateDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}