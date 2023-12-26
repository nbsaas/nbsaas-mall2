package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.ProductSpecValue;
import com.nbsaas.boot.product.api.domain.request.ProductSpecValueRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.product.data.entity.ProductSpec;

/**
* 请求对象转换成实体对象
*/

public class ProductSpecValueEntityConvert  implements Converter<ProductSpecValue, ProductSpecValueRequest> {

    @Override
    public ProductSpecValue convert(ProductSpecValueRequest source) {
        ProductSpecValue result = new ProductSpecValue();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getProductSpec()!=null){
                    ProductSpec productSpec =new ProductSpec();
                    productSpec.setId(source.getProductSpec());
                    result.setProductSpec(productSpec);
                    }
        return result;
    }
}

