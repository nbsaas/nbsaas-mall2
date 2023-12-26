package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.data.entity.Ad;
import com.nbsaas.boot.ad.api.domain.request.AdRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.ad.data.entity.AdPosition;

/**
* 请求对象转换成实体对象
*/

public class AdEntityConvert  implements Converter<Ad, AdRequest> {

    @Override
    public Ad convert(AdRequest source) {
        Ad result = new Ad();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getAdPosition()!=null){
                    AdPosition adPosition =new AdPosition();
                    adPosition.setId(source.getAdPosition());
                    result.setAdPosition(adPosition);
                    }
        return result;
    }
}

