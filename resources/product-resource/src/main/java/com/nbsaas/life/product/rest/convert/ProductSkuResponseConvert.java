package com.nbsaas.life.product.rest.convert;

import com.nbsaas.life.product.data.entity.ProductSku;
import com.nbsaas.life.product.api.domain.response.ProductSkuResponse;

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

