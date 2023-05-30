package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.SequenceSimple;
import com.nbsaas.life.system.data.entity.Sequence;
/**
* 列表对象转换器
*/

public class SequenceSimpleConvert implements Converter<SequenceSimple, Sequence> {




    @Override
    public SequenceSimple convert(Sequence source) {
        SequenceSimple result = new SequenceSimple();

        result.setIncrement(source.getIncrement());
        result.setCreateDate(source.getCreateDate());
        result.setUpdateDate(source.getUpdateDate());
        result.setLastDate(source.getLastDate());
        result.setName(source.getName());
        result.setId(source.getId());
        result.setCurrentNum(source.getCurrentNum());
        result.setAddDate(source.getAddDate());


    return result;
  }

}