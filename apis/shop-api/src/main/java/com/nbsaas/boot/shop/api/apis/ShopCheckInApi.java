package com.nbsaas.boot.shop.api.apis;

import com.nbsaas.boot.shop.api.domain.request.ShopCheckInRequest;
import com.nbsaas.boot.shop.api.domain.simple.ShopCheckInSimple;
import com.nbsaas.boot.shop.api.domain.response.ShopCheckInResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ShopCheckInApi extends BaseApi<ShopCheckInResponse, ShopCheckInSimple, ShopCheckInRequest> {


}
