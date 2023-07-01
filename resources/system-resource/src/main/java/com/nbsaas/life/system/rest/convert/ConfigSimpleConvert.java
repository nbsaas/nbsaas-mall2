package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Config;
import com.nbsaas.life.system.api.domain.simple.ConfigSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ConfigSimpleConvert implements Converter<ConfigSimple, Config> {




@Override
public ConfigSimple convert(Config source) {
    ConfigSimple result = new ConfigSimple();

                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setContent(source.getContent());
                result.setLastDate(source.getLastDate());


    return result;
}

}