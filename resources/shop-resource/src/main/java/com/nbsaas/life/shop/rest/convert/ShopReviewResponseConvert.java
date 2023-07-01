package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopReview;
import com.nbsaas.life.shop.api.domain.response.ShopReviewResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class ShopReviewResponseConvert  implements Converter
<ShopReviewResponse,ShopReview> {

@Override
public ShopReviewResponse convert(ShopReview source) {
ShopReviewResponse  result = new  ShopReviewResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}

}

