package com.nbsaas.boot.product.api.apis;

import com.nbsaas.boot.product.api.domain.request.ProductRequest;
import com.nbsaas.boot.product.api.domain.simple.ProductSimple;
import com.nbsaas.boot.product.api.domain.response.ProductResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ProductApi extends BaseApi<ProductResponse, ProductSimple, ProductRequest> {


}
