package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderHotelItem;
import com.nbsaas.boot.order.api.domain.response.OrderHotelItemResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class OrderHotelItemResponseConvert  implements Converter<OrderHotelItemResponse,OrderHotelItem> {

    @Override
    public OrderHotelItemResponse convert(OrderHotelItem source) {
        OrderHotelItemResponse  result = new  OrderHotelItemResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                        result.setShop(source.getShop().getId());
                    }
                    if(source.getShop()!=null){
                        result.setShopName(source.getShop().getName());
                    }
                    if(source.getOrder()!=null){
                        result.setOrder(source.getOrder().getId());
                    }
        return result;
    }

}

