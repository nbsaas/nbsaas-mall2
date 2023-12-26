package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopTag;
import com.nbsaas.life.shop.api.domain.request.ShopTagRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopTagEntityConvert  implements Converter<ShopTag, ShopTagRequest> {

    @Override
    public ShopTag convert(ShopTagRequest source) {
        ShopTag result = new ShopTag();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

