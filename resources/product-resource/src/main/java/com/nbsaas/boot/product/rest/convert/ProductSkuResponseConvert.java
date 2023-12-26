package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.ProductSku;
import com.nbsaas.boot.product.api.domain.response.ProductSkuResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ProductSkuResponseConvert  implements Converter<ProductSkuResponse,ProductSku> {

    @Override
    public ProductSkuResponse convert(ProductSku source) {
        ProductSkuResponse  result = new  ProductSkuResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getProduct()!=null){
                        result.setProduct(source.getProduct().getId());
                    }
        return result;
    }

}

