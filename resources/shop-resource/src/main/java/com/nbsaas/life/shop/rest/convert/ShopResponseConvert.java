package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.Shop;
import com.nbsaas.life.shop.api.domain.response.ShopResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class ShopResponseConvert  implements Converter<ShopResponse,Shop> {

    @Override
    public ShopResponse convert(Shop source) {
        ShopResponse  result = new  ShopResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

