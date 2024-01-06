package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderItem;
import com.nbsaas.boot.order.api.domain.simple.OrderItemSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class OrderItemSimpleConvert implements Converter<OrderItemSimple, OrderItem> {




@Override
public OrderItemSimple convert(OrderItem source) {
    OrderItemSimple result = new OrderItemSimple();

                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}