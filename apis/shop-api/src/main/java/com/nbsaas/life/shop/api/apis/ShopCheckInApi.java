package com.nbsaas.life.shop.api.apis;

import com.nbsaas.life.shop.api.domain.request.ShopCheckInDataRequest;
import com.nbsaas.life.shop.api.domain.simple.ShopCheckInSimple;
import com.nbsaas.life.shop.api.domain.response.ShopCheckInResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ShopCheckInApi extends BaseApi<ShopCheckInResponse, ShopCheckInSimple, ShopCheckInDataRequest> {


}
