package com.nbsaas.life.area.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.area.api.domain.simple.AreaSimple;
import com.nbsaas.life.area.data.entity.Area;

/**
 * 列表对象转换器
 */

public class AreaSimpleConvert implements Converter
        <AreaSimple, Area> {


    @Override
    public AreaSimple convert(Area source) {
        AreaSimple result = new AreaSimple();

        result.setLastDate(source.getLastDate());
        result.setLat(source.getLat());
        result.setSortNum(source.getSortNum());
        result.setId(source.getId());
        result.setCode(source.getCode());
        result.setLft(source.getLft());
        result.setRgt(source.getRgt());
        result.setDepth(source.getDepth());
        result.setName(source.getName());
        result.setLng(source.getLng());
        result.setIds(source.getIds());
        result.setAddDate(source.getAddDate());


        return result;
    }

}