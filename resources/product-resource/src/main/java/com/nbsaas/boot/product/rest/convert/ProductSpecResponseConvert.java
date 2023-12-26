package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.ProductSpec;
import com.nbsaas.boot.product.api.domain.response.ProductSpecResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ProductSpecResponseConvert  implements Converter<ProductSpecResponse,ProductSpec> {

    @Override
    public ProductSpecResponse convert(ProductSpec source) {
        ProductSpecResponse  result = new  ProductSpecResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getProduct()!=null){
                        result.setProduct(source.getProduct().getId());
                    }
        return result;
    }

}

