package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.response.DictResponse;
import com.nbsaas.life.system.data.entity.Dict;

/**
 * 实体对象转化成响应对象
 */

public class DictResponseConvert implements Converter
        <DictResponse, Dict> {

    @Override
    public DictResponse convert(Dict source) {
        DictResponse result = new DictResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

