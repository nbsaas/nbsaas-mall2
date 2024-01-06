package com.nbsaas.boot.order.api.apis;

import com.nbsaas.boot.order.api.domain.request.OrderItemRequest;
import com.nbsaas.boot.order.api.domain.simple.OrderItemSimple;
import com.nbsaas.boot.order.api.domain.response.OrderItemResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface OrderItemApi extends BaseApi<OrderItemResponse, OrderItemSimple, OrderItemRequest> {


}
