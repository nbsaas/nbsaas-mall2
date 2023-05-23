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

                    result.setCreateDate(source.getCreateDate());
                    result.setIp(source.getIp());
                    result.setLastDate(source.getLastDate());
                    result.setTitle(source.getTitle());
                    result.setApp(source.getApp());
                    result.setId(source.getId());
                    result.setCreateUser(source.getCreateUser());
                    result.setData(source.getData());
                    result.setAddDate(source.getAddDate());
                    result.setCreateName(source.getCreateName());


    return result;
  }

}