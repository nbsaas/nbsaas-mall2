package com.nbsaas.life.product.api.apis;

import com.nbsaas.life.product.api.domain.request.ProductSpecRequest;
import com.nbsaas.life.product.api.domain.simple.ProductSpecSimple;
import com.nbsaas.life.product.api.domain.response.ProductSpecResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ProductSpecApi extends BaseApi<ProductSpecResponse, ProductSpecSimple, ProductSpecRequest> {


}
