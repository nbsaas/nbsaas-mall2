package com.nbsaas.boot.order.api.apis;

import com.nbsaas.boot.order.api.domain.request.OrderHotelItemRequest;
import com.nbsaas.boot.order.api.domain.simple.OrderHotelItemSimple;
import com.nbsaas.boot.order.api.domain.response.OrderHotelItemResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface OrderHotelItemApi extends BaseApi<OrderHotelItemResponse, OrderHotelItemSimple, OrderHotelItemRequest> {


}
