package com.nbsaas.life.product.api.apis;

import com.nbsaas.life.product.api.domain.request.ProductCatalogRequest;
import com.nbsaas.life.product.api.domain.simple.ProductCatalogSimple;
import com.nbsaas.life.product.api.domain.response.ProductCatalogResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ProductCatalogApi extends BaseApi<ProductCatalogResponse, ProductCatalogSimple, ProductCatalogRequest> {


}
