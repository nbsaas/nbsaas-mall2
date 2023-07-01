package com.nbsaas.life.ad.rest.convert;

import com.nbsaas.life.ad.data.entity.AdPosition;
import com.nbsaas.life.ad.api.domain.simple.AdPositionSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class AdPositionSimpleConvert implements Converter<AdPositionSimple, AdPosition> {




@Override
public AdPositionSimple convert(AdPosition source) {
    AdPositionSimple result = new AdPositionSimple();

                result.setTemplate(source.getTemplate());
                result.setNote(source.getNote());
                result.setName(source.getName());
                result.setWidth(source.getWidth());
                result.setSortNum(source.getSortNum());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setKey(source.getKey());
                result.setHeight(source.getHeight());
                result.setLastDate(source.getLastDate());


    return result;
}

}