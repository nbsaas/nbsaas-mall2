package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.request.DictItemDataRequest;
import com.nbsaas.life.system.data.entity.Dict;
import com.nbsaas.life.system.data.entity.DictItem;

/**
 * 请求对象转换成实体对象
 */

public class DictItemEntityConvert implements Converter<DictItem, DictItemDataRequest> {
    @Override
    public DictItem convert(DictItemDataRequest source) {
        DictItem result = new DictItem();
        BeanDataUtils.copyProperties(source, result);
        if (source.getDict() != null) {
            Dict dict = new Dict();
            dict.setId(source.getDict());
            result.setDict(dict);
        }
        return result;
    }
}

