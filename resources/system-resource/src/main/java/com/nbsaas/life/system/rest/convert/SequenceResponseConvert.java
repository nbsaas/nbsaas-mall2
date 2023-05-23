package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Sequence;
import com.nbsaas.life.system.api.domain.response.SequenceResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class SequenceResponseConvert  implements Converter<SequenceResponse,Sequence> {

    @Override
    public SequenceResponse convert(Sequence source) {
        SequenceResponse  result = new  SequenceResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

