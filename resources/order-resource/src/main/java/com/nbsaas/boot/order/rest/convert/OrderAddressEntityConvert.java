package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderAddress;
import com.nbsaas.boot.order.api.domain.request.OrderAddressRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.area.data.entity.Area;
            import com.nbsaas.boot.area.data.entity.Area;
            import com.nbsaas.boot.area.data.entity.Area;
            import com.nbsaas.boot.order.data.entity.Order;

/**
* 请求对象转换成实体对象
*/

public class OrderAddressEntityConvert  implements Converter<OrderAddress, OrderAddressRequest> {

    @Override
    public OrderAddress convert(OrderAddressRequest source) {
        OrderAddress result = new OrderAddress();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getArea()!=null){
                    Area area =new Area();
                    area.setId(source.getArea());
                    result.setArea(area);
                    }
                    if(source.getCity()!=null){
                    Area city =new Area();
                    city.setId(source.getCity());
                    result.setCity(city);
                    }
                    if(source.getProvince()!=null){
                    Area province =new Area();
                    province.setId(source.getProvince());
                    result.setProvince(province);
                    }
                    if(source.getOrder()!=null){
                    Order order =new Order();
                    order.setId(source.getOrder());
                    result.setOrder(order);
                    }
        return result;
    }
}

