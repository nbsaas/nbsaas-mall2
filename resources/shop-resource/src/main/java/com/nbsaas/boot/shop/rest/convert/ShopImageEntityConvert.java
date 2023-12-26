package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopImage;
import com.nbsaas.boot.shop.api.domain.request.ShopImageRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopImageEntityConvert  implements Converter<ShopImage, ShopImageRequest> {

    @Override
    public ShopImage convert(ShopImageRequest source) {
        ShopImage result = new ShopImage();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

