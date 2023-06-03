package com.nbsaas.life.area.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.area.api.domain.simple.AreaHotSimple;
import com.nbsaas.life.area.data.entity.AreaHot;

/**
 * 列表对象转换器
 */

public class AreaHotSimpleConvert implements Converter
        <AreaHotSimple, AreaHot> {


    @Override
    public AreaHotSimple convert(AreaHot source) {
        AreaHotSimple result = new AreaHotSimple();

        result.setLastDate(source.getLastDate());
        result.setSortNum(source.getSortNum());
        result.setId(source.getId());
        if (source.getArea() != null) {
            result.setAreaName(source.getArea().getName());
        }
        if (source.getArea() != null) {
            result.setArea(source.getArea().getId());
        }
        result.setAddDate(source.getAddDate());


        return result;
    }

}