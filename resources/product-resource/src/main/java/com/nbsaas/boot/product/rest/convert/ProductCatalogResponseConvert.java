package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.ProductCatalog;
import com.nbsaas.boot.product.api.domain.response.ProductCatalogResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ProductCatalogResponseConvert  implements Converter<ProductCatalogResponse,ProductCatalog> {

    @Override
    public ProductCatalogResponse convert(ProductCatalog source) {
        ProductCatalogResponse  result = new  ProductCatalogResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getParent()!=null){
                        result.setParent(source.getParent().getId());
                    }
                    if(source.getParent()!=null){
                        result.setParentName(source.getParent().getName());
                    }
        return result;
    }

}

