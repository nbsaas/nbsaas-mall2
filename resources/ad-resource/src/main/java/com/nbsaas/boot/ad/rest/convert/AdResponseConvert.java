package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.data.entity.Ad;
import com.nbsaas.boot.ad.api.domain.response.AdResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class AdResponseConvert  implements Converter<AdResponse,Ad> {

    @Override
    public AdResponse convert(Ad source) {
        AdResponse  result = new  AdResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getAdPosition()!=null){
                        result.setAdPosition(source.getAdPosition().getId());
                    }
                    if(source.getAdPosition()!=null){
                        result.setAdPositionName(source.getAdPosition().getName());
                    }
        return result;
    }

}

