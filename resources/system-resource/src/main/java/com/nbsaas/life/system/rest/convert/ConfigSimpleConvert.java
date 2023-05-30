package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.ConfigSimple;
import com.nbsaas.life.system.data.entity.Config;
/**
* 列表对象转换器
*/

public class ConfigSimpleConvert implements Converter<ConfigSimple, Config> {




    @Override
    public ConfigSimple convert(Config source) {
        ConfigSimple result = new ConfigSimple();

        result.setLastDate(source.getLastDate());
        result.setId(source.getId());
        result.setContent(source.getContent());
                    result.setAddDate(source.getAddDate());


    return result;
  }

}