package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.Product;
import com.nbsaas.boot.product.api.domain.response.ProductResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ProductResponseConvert  implements Converter<ProductResponse,Product> {

    @Override
    public ProductResponse convert(Product source) {
        ProductResponse  result = new  ProductResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getStoreState()!=null){
                        result.setStoreStateName(String.valueOf(source.getStoreState()));
                    }
        return result;
    }

}

