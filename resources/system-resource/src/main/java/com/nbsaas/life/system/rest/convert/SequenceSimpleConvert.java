package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Sequence;
import com.nbsaas.life.system.api.domain.simple.SequenceSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class SequenceSimpleConvert implements Converter<SequenceSimple, Sequence> {




@Override
public SequenceSimple convert(Sequence source) {
    SequenceSimple result = new SequenceSimple();

                result.setUpdateDate(source.getUpdateDate());
                result.setName(source.getName());
                result.setIncrement(source.getIncrement());
                result.setCurrentNum(source.getCurrentNum());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setCreateDate(source.getCreateDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}