package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.DictSimple;
import com.nbsaas.life.system.data.entity.Dict;

/**
 * 列表对象转换器
 */

public class DictSimpleConvert implements Converter
        <DictSimple, Dict> {


    @Override
    public DictSimple convert(Dict source) {
        DictSimple result = new DictSimple();

        result.setTitle(source.getTitle());
        result.setLastDate(source.getLastDate());
        result.setId(source.getId());
        result.setDictKey(source.getDictKey());
        result.setAddDate(source.getAddDate());


        return result;
    }

}