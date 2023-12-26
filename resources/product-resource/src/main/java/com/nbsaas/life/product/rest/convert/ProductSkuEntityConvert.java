package com.nbsaas.life.product.rest.convert;

import com.nbsaas.life.product.data.entity.ProductSku;
import com.nbsaas.life.product.api.domain.request.ProductSkuRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.life.product.data.entity.Product;

/**
* 请求对象转换成实体对象
*/

public class ProductSkuEntityConvert  implements Converter<ProductSku, ProductSkuRequest> {

    @Override
    public ProductSku convert(ProductSkuRequest source) {
        ProductSku result = new ProductSku();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getProduct()!=null){
                    Product product =new Product();
                    product.setId(source.getProduct());
                    result.setProduct(product);
                    }
        return result;
    }
}

