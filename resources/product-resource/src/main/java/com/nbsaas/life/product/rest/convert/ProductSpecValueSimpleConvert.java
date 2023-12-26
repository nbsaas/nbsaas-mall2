package com.nbsaas.life.product.rest.convert;

import com.nbsaas.life.product.data.entity.ProductSpecValue;
import com.nbsaas.life.product.api.domain.simple.ProductSpecValueSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ProductSpecValueSimpleConvert implements Converter<ProductSpecValueSimple, ProductSpecValue> {




@Override
public ProductSpecValueSimple convert(ProductSpecValue source) {
    ProductSpecValueSimple result = new ProductSpecValueSimple();

                if(source.getProductSpec()!=null){
                    result.setProductSpecName(source.getProductSpec().getName());
                }
                result.setName(source.getName());
                result.setId(source.getId());
                if(source.getProductSpec()!=null){
                    result.setProductSpec(source.getProductSpec().getId());
                }
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}