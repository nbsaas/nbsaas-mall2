package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopReview;
import com.nbsaas.life.shop.api.domain.request.ShopReviewDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopReviewEntityConvert  implements Converter<ShopReview, ShopReviewDataRequest> {

    @Override
    public ShopReview convert(ShopReviewDataRequest source) {
        ShopReview result = new ShopReview();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

