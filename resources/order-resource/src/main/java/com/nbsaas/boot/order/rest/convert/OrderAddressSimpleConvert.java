package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderAddress;
import com.nbsaas.boot.order.api.domain.simple.OrderAddressSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class OrderAddressSimpleConvert implements Converter<OrderAddressSimple, OrderAddress> {




@Override
public OrderAddressSimple convert(OrderAddress source) {
    OrderAddressSimple result = new OrderAddressSimple();

                if(source.getArea()!=null){
                    result.setArea(source.getArea().getId());
                }
                result.setNote(source.getNote());
                result.setAddress(source.getAddress());
                result.setConsignee(source.getConsignee());
                result.setLng(source.getLng());
                if(source.getCity()!=null){
                    result.setCity(source.getCity().getId());
                }
                result.setPostalCode(source.getPostalCode());
                result.setLabel(source.getLabel());
                result.setAddDate(source.getAddDate());
                if(source.getProvince()!=null){
                    result.setProvince(source.getProvince().getId());
                }
                if(source.getCity()!=null){
                    result.setCityName(source.getCity().getName());
                }
                if(source.getArea()!=null){
                    result.setAreaName(source.getArea().getName());
                }
                result.setPhone(source.getPhone());
                result.setHouseNo(source.getHouseNo());
                result.setTel(source.getTel());
                if(source.getProvince()!=null){
                    result.setProvinceName(source.getProvince().getName());
                }
                result.setId(source.getId());
                result.setLat(source.getLat());
                if(source.getOrder()!=null){
                    result.setOrder(source.getOrder().getId());
                }
                result.setLastDate(source.getLastDate());


    return result;
}

}