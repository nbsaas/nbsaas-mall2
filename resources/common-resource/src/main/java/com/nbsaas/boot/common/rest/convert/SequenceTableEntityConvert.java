package com.nbsaas.boot.common.rest.convert;

import com.nbsaas.boot.common.data.entity.SequenceTable;
import com.nbsaas.boot.common.api.domain.request.SequenceTableRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class SequenceTableEntityConvert  implements Converter<SequenceTable, SequenceTableRequest> {

    @Override
    public SequenceTable convert(SequenceTableRequest source) {
        SequenceTable result = new SequenceTable();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

