package com.nbsaas.boot.common.rest.convert;

import com.nbsaas.boot.common.data.entity.SequenceTable;
import com.nbsaas.boot.common.api.domain.simple.SequenceTableSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class SequenceTableSimpleConvert implements Converter<SequenceTableSimple, SequenceTable> {




@Override
public SequenceTableSimple convert(SequenceTable source) {
    SequenceTableSimple result = new SequenceTableSimple();

                result.setName(source.getName());
                result.setStep(source.getStep());
                result.setId(source.getId());
                result.setValue(source.getValue());


    return result;
}

}