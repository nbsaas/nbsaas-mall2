package com.nbsaas.life.ad.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.ad.api.domain.response.AdPositionResponse;
import com.nbsaas.life.ad.data.entity.AdPosition;

/**
 * 实体对象转化成响应对象
 */

public class AdPositionResponseConvert implements Converter
        <AdPositionResponse, AdPosition> {

    @Override
    public AdPositionResponse convert(AdPosition source) {
        AdPositionResponse result = new AdPositionResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

