package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.ProductSpec;
import com.nbsaas.boot.product.api.domain.simple.ProductSpecSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ProductSpecSimpleConvert implements Converter<ProductSpecSimple, ProductSpec> {




@Override
public ProductSpecSimple convert(ProductSpec source) {
    ProductSpecSimple result = new ProductSpecSimple();

                if(source.getProduct()!=null){
                    result.setProduct(source.getProduct().getId());
                }
                result.setName(source.getName());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}