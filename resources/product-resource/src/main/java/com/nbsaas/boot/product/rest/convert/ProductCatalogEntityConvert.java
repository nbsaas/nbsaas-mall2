package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.ProductCatalog;
import com.nbsaas.boot.product.api.domain.request.ProductCatalogRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.product.data.entity.ProductCatalog;

/**
* 请求对象转换成实体对象
*/

public class ProductCatalogEntityConvert  implements Converter<ProductCatalog, ProductCatalogRequest> {

    @Override
    public ProductCatalog convert(ProductCatalogRequest source) {
        ProductCatalog result = new ProductCatalog();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getParent()!=null){
                    ProductCatalog parent =new ProductCatalog();
                    parent.setId(source.getParent());
                    result.setParent(parent);
                    }
        return result;
    }
}

