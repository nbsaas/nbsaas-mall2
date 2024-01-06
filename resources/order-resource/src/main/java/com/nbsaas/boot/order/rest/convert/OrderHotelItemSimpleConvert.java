package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderHotelItem;
import com.nbsaas.boot.order.api.domain.simple.OrderHotelItemSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class OrderHotelItemSimpleConvert implements Converter<OrderHotelItemSimple, OrderHotelItem> {




@Override
public OrderHotelItemSimple convert(OrderHotelItem source) {
    OrderHotelItemSimple result = new OrderHotelItemSimple();

                result.setNote(source.getNote());
                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                result.setPhone(source.getPhone());
                result.setPrice(source.getPrice());
                result.setName(source.getName());
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                result.setBeginTime(source.getBeginTime());
                result.setEndTime(source.getEndTime());
                result.setId(source.getId());
                if(source.getOrder()!=null){
                    result.setOrder(source.getOrder().getId());
                }


    return result;
}

}