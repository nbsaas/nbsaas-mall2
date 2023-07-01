package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Dict;
import com.nbsaas.life.system.api.domain.simple.DictSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class DictSimpleConvert implements Converter<DictSimple, Dict> {




@Override
public DictSimple convert(Dict source) {
    DictSimple result = new DictSimple();

                result.setId(source.getId());
                result.setTitle(source.getTitle());
                result.setDictKey(source.getDictKey());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}