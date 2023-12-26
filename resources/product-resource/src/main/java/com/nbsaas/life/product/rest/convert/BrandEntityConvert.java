package com.nbsaas.life.product.rest.convert;

import com.nbsaas.life.product.data.entity.Brand;
import com.nbsaas.life.product.api.domain.request.BrandRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class BrandEntityConvert  implements Converter<Brand, BrandRequest> {

    @Override
    public Brand convert(BrandRequest source) {
        Brand result = new Brand();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

