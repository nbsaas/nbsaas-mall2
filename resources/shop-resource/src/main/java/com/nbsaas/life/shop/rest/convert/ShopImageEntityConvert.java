package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopImage;
import com.nbsaas.life.shop.api.domain.request.ShopImageDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopImageEntityConvert  implements Converter<ShopImage, ShopImageDataRequest> {

    @Override
    public ShopImage convert(ShopImageDataRequest source) {
        ShopImage result = new ShopImage();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

