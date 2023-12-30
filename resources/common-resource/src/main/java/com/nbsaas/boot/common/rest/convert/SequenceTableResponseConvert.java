package com.nbsaas.boot.common.rest.convert;

import com.nbsaas.boot.common.data.entity.SequenceTable;
import com.nbsaas.boot.common.api.domain.response.SequenceTableResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class SequenceTableResponseConvert  implements Converter<SequenceTableResponse,SequenceTable> {

    @Override
    public SequenceTableResponse convert(SequenceTable source) {
        SequenceTableResponse  result = new  SequenceTableResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

