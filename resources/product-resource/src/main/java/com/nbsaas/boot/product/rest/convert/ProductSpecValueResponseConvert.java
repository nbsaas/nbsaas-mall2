package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.ProductSpecValue;
import com.nbsaas.boot.product.api.domain.response.ProductSpecValueResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ProductSpecValueResponseConvert  implements Converter<ProductSpecValueResponse,ProductSpecValue> {

    @Override
    public ProductSpecValueResponse convert(ProductSpecValue source) {
        ProductSpecValueResponse  result = new  ProductSpecValueResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getProductSpec()!=null){
                        result.setProductSpecName(source.getProductSpec().getName());
                    }
                    if(source.getProductSpec()!=null){
                        result.setProductSpec(source.getProductSpec().getId());
                    }
        return result;
    }

}

