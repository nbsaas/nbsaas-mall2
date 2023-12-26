package com.nbsaas.boot.product.api.apis;

import com.nbsaas.boot.product.api.domain.request.ProductSkuRequest;
import com.nbsaas.boot.product.api.domain.simple.ProductSkuSimple;
import com.nbsaas.boot.product.api.domain.response.ProductSkuResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ProductSkuApi extends BaseApi<ProductSkuResponse, ProductSkuSimple, ProductSkuRequest> {


}
