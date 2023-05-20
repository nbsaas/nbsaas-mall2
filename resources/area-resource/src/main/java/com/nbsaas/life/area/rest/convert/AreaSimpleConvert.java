package com.nbsaas.life.area.rest.convert;

import com.nbsaas.life.area.data.entity.Area;
import com.nbsaas.life.area.api.domain.simple.AreaSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class AreaSimpleConvert implements Converter<AreaSimple, Area> {




    @Override
    public AreaSimple convert(Area source) {
        AreaSimple result = new AreaSimple();

                    result.setRgt(source.getRgt());
                    result.setIds(source.getIds());
                    result.setLat(source.getLat());
                    result.setLastDate(source.getLastDate());
                    result.setLng(source.getLng());
                    result.setSortNum(source.getSortNum());
                    result.setId(source.getId());
                    result.setLft(source.getLft());
                    result.setAddDate(source.getAddDate());
                    result.setName(source.getName());
                    result.setDepth(source.getDepth());
                    result.setCode(source.getCode());


    return result;
  }

}