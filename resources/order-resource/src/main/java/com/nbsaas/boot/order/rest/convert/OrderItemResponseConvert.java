package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderItem;
import com.nbsaas.boot.order.api.domain.response.OrderItemResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class OrderItemResponseConvert  implements Converter<OrderItemResponse,OrderItem> {

    @Override
    public OrderItemResponse convert(OrderItem source) {
        OrderItemResponse  result = new  OrderItemResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

