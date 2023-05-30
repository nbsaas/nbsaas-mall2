package com.nbsaas.life.ad.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.ad.api.domain.response.AdResponse;
import com.nbsaas.life.ad.data.entity.Ad;

/**
* 实体对象转化成响应对象
*/

public class AdResponseConvert  implements Converter<AdResponse,Ad> {

    @Override
    public AdResponse convert(Ad source) {
        AdResponse result = new AdResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getAdPosition() != null) {
            result.setAdPosition(source.getAdPosition().getId());
        }
        if (source.getAdPosition() != null) {
            result.setAdPositionName(source.getAdPosition().getName());
        }
        return result;
    }

}

