package com.nbsaas.life.product.rest.convert;

import com.nbsaas.life.product.data.entity.ProductSpec;
import com.nbsaas.life.product.api.domain.request.ProductSpecRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.life.product.data.entity.Product;

/**
* 请求对象转换成实体对象
*/

public class ProductSpecEntityConvert  implements Converter<ProductSpec, ProductSpecRequest> {

    @Override
    public ProductSpec convert(ProductSpecRequest source) {
        ProductSpec result = new ProductSpec();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getProduct()!=null){
                    Product product =new Product();
                    product.setId(source.getProduct());
                    result.setProduct(product);
                    }
        return result;
    }
}

