package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.OrderHotelItem;
import com.nbsaas.boot.order.api.domain.request.OrderHotelItemRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.shop.data.entity.Shop;
            import com.nbsaas.boot.order.data.entity.Order;

/**
* 请求对象转换成实体对象
*/

public class OrderHotelItemEntityConvert  implements Converter<OrderHotelItem, OrderHotelItemRequest> {

    @Override
    public OrderHotelItem convert(OrderHotelItemRequest source) {
        OrderHotelItem result = new OrderHotelItem();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
                    if(source.getOrder()!=null){
                    Order order =new Order();
                    order.setId(source.getOrder());
                    result.setOrder(order);
                    }
        return result;
    }
}

