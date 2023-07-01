package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopImage;
import com.nbsaas.life.shop.api.domain.response.ShopImageResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class ShopImageResponseConvert  implements Converter
<ShopImageResponse,ShopImage> {

@Override
public ShopImageResponse convert(ShopImage source) {
ShopImageResponse  result = new  ShopImageResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}

}

