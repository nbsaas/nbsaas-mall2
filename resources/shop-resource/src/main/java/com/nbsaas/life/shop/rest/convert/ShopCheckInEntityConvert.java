package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopCheckIn;
import com.nbsaas.life.shop.api.domain.request.ShopCheckInDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopCheckInEntityConvert  implements Converter<ShopCheckIn, ShopCheckInDataRequest> {

    @Override
    public ShopCheckIn convert(ShopCheckInDataRequest source) {
        ShopCheckIn result = new ShopCheckIn();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

