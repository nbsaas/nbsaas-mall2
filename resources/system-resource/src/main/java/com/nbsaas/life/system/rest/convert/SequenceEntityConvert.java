package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Sequence;
import com.nbsaas.life.system.api.domain.request.SequenceDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class SequenceEntityConvert  implements Converter<Sequence, SequenceDataRequest> {

    @Override
    public Sequence convert(SequenceDataRequest source) {
        Sequence result = new Sequence();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

