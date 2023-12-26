package com.nbsaas.life.product.rest.convert;

import com.nbsaas.life.product.data.entity.Product;
import com.nbsaas.life.product.api.domain.request.ProductRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ProductEntityConvert  implements Converter<Product, ProductRequest> {

    @Override
    public Product convert(ProductRequest source) {
        Product result = new Product();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

