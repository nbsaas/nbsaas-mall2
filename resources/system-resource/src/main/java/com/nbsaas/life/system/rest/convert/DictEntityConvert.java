package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.request.DictDataRequest;
import com.nbsaas.life.system.data.entity.Dict;

/**
 * 请求对象转换成实体对象
 */

public class DictEntityConvert implements Converter<Dict, DictDataRequest> {
    @Override
    public Dict convert(DictDataRequest source) {
        Dict result = new Dict();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

