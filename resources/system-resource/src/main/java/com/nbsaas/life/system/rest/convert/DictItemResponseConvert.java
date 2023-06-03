package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.response.DictItemResponse;
import com.nbsaas.life.system.data.entity.DictItem;

/**
 * 实体对象转化成响应对象
 */

public class DictItemResponseConvert implements Converter
        <DictItemResponse, DictItem> {

    @Override
    public DictItemResponse convert(DictItem source) {
        DictItemResponse result = new DictItemResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getDict() != null) {
            result.setDict(source.getDict().getId());
        }
        return result;
    }

}

