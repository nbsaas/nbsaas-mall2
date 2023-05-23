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

                    result.setCreateDate(source.getCreateDate());
                    result.setCurrentNum(source.getCurrentNum());
                    result.setLastDate(source.getLastDate());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setName(source.getName());
                    result.setIncrement(source.getIncrement());
                    result.setUpdateDate(source.getUpdateDate());


    return result;
  }

}