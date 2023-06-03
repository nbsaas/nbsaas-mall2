package com.nbsaas.life.area.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.area.api.domain.response.AreaHotResponse;
import com.nbsaas.life.area.data.entity.AreaHot;

/**
 * 实体对象转化成响应对象
 */

public class AreaHotResponseConvert implements Converter
        <AreaHotResponse, AreaHot> {

    @Override
    public AreaHotResponse convert(AreaHot source) {
        AreaHotResponse result = new AreaHotResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getArea() != null) {
            result.setAreaName(source.getArea().getName());
        }
        if (source.getArea() != null) {
            result.setArea(source.getArea().getId());
        }
        return result;
    }

}

