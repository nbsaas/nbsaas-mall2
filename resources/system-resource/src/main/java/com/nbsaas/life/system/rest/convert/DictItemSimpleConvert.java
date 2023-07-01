package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.DictItem;
import com.nbsaas.life.system.api.domain.simple.DictItemSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class DictItemSimpleConvert implements Converter<DictItemSimple, DictItem> {




@Override
public DictItemSimple convert(DictItem source) {
    DictItemSimple result = new DictItemSimple();

                if(source.getDict()!=null){
                    result.setDictTitle(source.getDict().getTitle());
                }
                result.setDataValue(source.getDataValue());
                if(source.getDict()!=null){
                    result.setDict(source.getDict().getId());
                }
                result.setSortNum(source.getSortNum());
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                result.setId(source.getId());
                result.setDataCode(source.getDataCode());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}