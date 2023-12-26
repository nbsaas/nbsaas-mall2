package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopCategory;
import com.nbsaas.life.shop.api.domain.request.ShopCategoryRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopCategoryEntityConvert  implements Converter<ShopCategory, ShopCategoryRequest> {

    @Override
    public ShopCategory convert(ShopCategoryRequest source) {
        ShopCategory result = new ShopCategory();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

