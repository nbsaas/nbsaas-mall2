package com.nbsaas.life.area.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.area.api.domain.response.AreaResponse;
import com.nbsaas.life.area.data.entity.Area;

/**
 * 实体对象转化成响应对象
 */

public class AreaResponseConvert implements Converter
        <AreaResponse, Area> {

    @Override
    public AreaResponse convert(Area source) {
        AreaResponse result = new AreaResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

