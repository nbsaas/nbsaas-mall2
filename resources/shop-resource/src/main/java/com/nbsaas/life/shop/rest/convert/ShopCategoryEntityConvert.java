package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopCategory;
import com.nbsaas.life.shop.api.domain.request.ShopCategoryDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ShopCategoryEntityConvert  implements Converter<ShopCategory, ShopCategoryDataRequest> {

    @Override
    public ShopCategory convert(ShopCategoryDataRequest source) {
        ShopCategory result = new ShopCategory();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

