package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.Shop;
import com.nbsaas.life.shop.api.domain.request.ShopDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopEntityConvert  implements Converter<Shop, ShopDataRequest> {
@Override
public Shop convert(ShopDataRequest source) {
Shop result = new Shop();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

