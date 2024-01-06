package com.nbsaas.boot.order.api.apis;

import com.nbsaas.boot.order.api.domain.request.OrderAddressRequest;
import com.nbsaas.boot.order.api.domain.simple.OrderAddressSimple;
import com.nbsaas.boot.order.api.domain.response.OrderAddressResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface OrderAddressApi extends BaseApi<OrderAddressResponse, OrderAddressSimple, OrderAddressRequest> {


}
