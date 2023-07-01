package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopCategory;
import com.nbsaas.life.shop.api.domain.response.ShopCategoryResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class ShopCategoryResponseConvert  implements Converter
<ShopCategoryResponse,ShopCategory> {

@Override
public ShopCategoryResponse convert(ShopCategory source) {
ShopCategoryResponse  result = new  ShopCategoryResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}

}

