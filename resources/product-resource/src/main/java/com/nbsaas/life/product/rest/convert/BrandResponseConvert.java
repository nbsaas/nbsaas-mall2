package com.nbsaas.life.product.rest.convert;

import com.nbsaas.life.product.data.entity.Brand;
import com.nbsaas.life.product.api.domain.response.BrandResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class BrandResponseConvert  implements Converter<BrandResponse,Brand> {

    @Override
    public BrandResponse convert(Brand source) {
        BrandResponse  result = new  BrandResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

