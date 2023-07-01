package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopTag;
import com.nbsaas.life.shop.api.domain.request.ShopTagDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopTagEntityConvert  implements Converter<ShopTag, ShopTagDataRequest> {

    @Override
    public ShopTag convert(ShopTagDataRequest source) {
        ShopTag result = new ShopTag();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

