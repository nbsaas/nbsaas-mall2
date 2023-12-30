package com.nbsaas.boot.order.api.apis;

import com.nbsaas.boot.order.api.domain.request.OrderRequest;
import com.nbsaas.boot.order.api.domain.simple.OrderSimple;
import com.nbsaas.boot.order.api.domain.response.OrderResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface OrderApi extends BaseApi<OrderResponse, OrderSimple, OrderRequest> {


}
