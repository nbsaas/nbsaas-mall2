package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.data.entity.AdPosition;
import com.nbsaas.boot.ad.api.domain.request.AdPositionRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class AdPositionEntityConvert  implements Converter<AdPosition, AdPositionRequest> {

    @Override
    public AdPosition convert(AdPositionRequest source) {
        AdPosition result = new AdPosition();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

