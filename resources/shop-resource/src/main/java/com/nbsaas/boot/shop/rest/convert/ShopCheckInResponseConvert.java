package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopCheckIn;
import com.nbsaas.boot.shop.api.domain.response.ShopCheckInResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopCheckInResponseConvert  implements Converter<ShopCheckInResponse,ShopCheckIn> {

    @Override
    public ShopCheckInResponse convert(ShopCheckIn source) {
        ShopCheckInResponse  result = new  ShopCheckInResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

