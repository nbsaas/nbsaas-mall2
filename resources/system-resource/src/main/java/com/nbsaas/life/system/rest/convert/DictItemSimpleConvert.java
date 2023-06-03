package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.DictItemSimple;
import com.nbsaas.life.system.data.entity.DictItem;

/**
 * 列表对象转换器
 */

public class DictItemSimpleConvert implements Converter
        <DictItemSimple, DictItem> {


    @Override
    public DictItemSimple convert(DictItem source) {
        DictItemSimple result = new DictItemSimple();

        result.setLastDate(source.getLastDate());
        result.setId(source.getId());
        result.setStoreState(source.getStoreState());
        result.setSortNum(source.getSortNum());
        result.setDataValue(source.getDataValue());
        result.setDataCode(source.getDataCode());
        if (source.getDict() != null) {
            result.setDict(source.getDict().getId());
        }
        result.setAddDate(source.getAddDate());


        return result;
    }

}