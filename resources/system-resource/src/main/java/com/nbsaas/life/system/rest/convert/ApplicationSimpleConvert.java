package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.ApplicationSimple;
import com.nbsaas.life.system.data.entity.Application;
/**
* 列表对象转换器
*/

public class ApplicationSimpleConvert implements Converter<ApplicationSimple, Application> {




    @Override
    public ApplicationSimple convert(Application source) {
        ApplicationSimple result = new ApplicationSimple();

        result.setLastDate(source.getLastDate());
        result.setAppKey(source.getAppKey());
        result.setName(source.getName());
        result.setId(source.getId());
        result.setNote(source.getNote());
        result.setAddDate(source.getAddDate());


        return result;
    }

}