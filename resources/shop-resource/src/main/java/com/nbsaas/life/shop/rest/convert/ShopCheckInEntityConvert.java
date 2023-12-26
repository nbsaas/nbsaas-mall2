package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopCheckIn;
import com.nbsaas.life.shop.api.domain.request.ShopCheckInRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopCheckInEntityConvert  implements Converter<ShopCheckIn, ShopCheckInRequest> {

    @Override
    public ShopCheckIn convert(ShopCheckInRequest source) {
        ShopCheckIn result = new ShopCheckIn();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

