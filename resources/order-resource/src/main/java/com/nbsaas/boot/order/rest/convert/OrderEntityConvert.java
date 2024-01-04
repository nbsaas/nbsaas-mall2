package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.Order;
import com.nbsaas.boot.order.api.domain.request.OrderRequest;

import com.nbsaas.boot.order.ext.domain.simple.OrderExt;
import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class OrderEntityConvert  implements Converter<Order, OrderRequest> {

    @Override
    public Order convert(OrderRequest source) {
        Order result = new Order();
        BeanDataUtils.copyProperties(source, result);
        OrderExt ext=new OrderExt();
        ext.setNote("ada");
        ext.setRemark("dfsd");
        result.setOrderExt(ext);
        return result;
    }
}

