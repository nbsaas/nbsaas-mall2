package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopTag;
import com.nbsaas.boot.shop.api.domain.response.ShopTagResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopTagResponseConvert  implements Converter<ShopTagResponse,ShopTag> {

    @Override
    public ShopTagResponse convert(ShopTag source) {
        ShopTagResponse  result = new  ShopTagResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

