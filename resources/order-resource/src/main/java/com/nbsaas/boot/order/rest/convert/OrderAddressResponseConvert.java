package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderAddress;
import com.nbsaas.boot.order.api.domain.response.OrderAddressResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class OrderAddressResponseConvert  implements Converter<OrderAddressResponse,OrderAddress> {

    @Override
    public OrderAddressResponse convert(OrderAddress source) {
        OrderAddressResponse  result = new  OrderAddressResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getArea()!=null){
                        result.setArea(source.getArea().getId());
                    }
                    if(source.getCity()!=null){
                        result.setCity(source.getCity().getId());
                    }
                    if(source.getProvince()!=null){
                        result.setProvince(source.getProvince().getId());
                    }
                    if(source.getCity()!=null){
                        result.setCityName(source.getCity().getName());
                    }
                    if(source.getArea()!=null){
                        result.setAreaName(source.getArea().getName());
                    }
                    if(source.getProvince()!=null){
                        result.setProvinceName(source.getProvince().getName());
                    }
                    if(source.getOrder()!=null){
                        result.setOrder(source.getOrder().getId());
                    }
        return result;
    }

}

