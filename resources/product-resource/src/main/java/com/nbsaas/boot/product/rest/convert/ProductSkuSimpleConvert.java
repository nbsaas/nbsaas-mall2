package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.ProductSku;
import com.nbsaas.boot.product.api.domain.simple.ProductSkuSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ProductSkuSimpleConvert implements Converter<ProductSkuSimple, ProductSku> {




@Override
public ProductSkuSimple convert(ProductSku source) {
    ProductSkuSimple result = new ProductSkuSimple();

                if(source.getProduct()!=null){
                    result.setProduct(source.getProduct().getId());
                }
                result.setPrice(source.getPrice());
                result.setName(source.getName());
                result.setStockNum(source.getStockNum());
                result.setDiscount(source.getDiscount());
                result.setMealFee(source.getMealFee());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setSpec(source.getSpec());
                result.setLastDate(source.getLastDate());


    return result;
}

}