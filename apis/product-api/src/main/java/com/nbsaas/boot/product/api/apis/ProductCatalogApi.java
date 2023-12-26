package com.nbsaas.boot.product.api.apis;

import com.nbsaas.boot.product.api.domain.request.ProductCatalogRequest;
import com.nbsaas.boot.product.api.domain.simple.ProductCatalogSimple;
import com.nbsaas.boot.product.api.domain.response.ProductCatalogResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ProductCatalogApi extends BaseApi<ProductCatalogResponse, ProductCatalogSimple, ProductCatalogRequest> {


}
