package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderItem;
import com.nbsaas.boot.order.api.domain.request.OrderItemRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class OrderItemEntityConvert  implements Converter<OrderItem, OrderItemRequest> {

    @Override
    public OrderItem convert(OrderItemRequest source) {
        OrderItem result = new OrderItem();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

