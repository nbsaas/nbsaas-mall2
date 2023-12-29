package com.nbsaas.boot.order.rest.convert;

import com.nbsaas.boot.order.data.entity.Order;
import com.nbsaas.boot.order.api.domain.response.OrderResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import java.util.HashMap;
import java.util.Map;
/**
* 实体对象转化成响应对象
*/

public class OrderResponseConvert  implements Converter<OrderResponse,Order> {

    @Override
    public OrderResponse convert(Order source) {
        OrderResponse  result = new  OrderResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getSourceClient()!=null){
                    Map<Integer,String> SourceClientMap=new HashMap<>();
                        SourceClientMap.put(1,"微信");
                        SourceClientMap.put(2,"支付宝");
                        SourceClientMap.put(3,"银联");
                        SourceClientMap.put(4,"快捷支付");
                        SourceClientMap.put(5,"微信公众号");
                        SourceClientMap.put(6,"微信小程序");
                    String label=  SourceClientMap.get(source.getSourceClient());
                    result.setSourceClientName(label);
                    }
                    result.setSourceClient(source.getSourceClient());
                    if(source.getCatalog()!=null){
                    Map<Integer,String> CatalogMap=new HashMap<>();
                        CatalogMap.put(1,"普通订单");
                        CatalogMap.put(2,"团购订单");
                        CatalogMap.put(3,"秒杀订单");
                    String label=  CatalogMap.get(source.getCatalog());
                    result.setCatalogName(label);
                    }
                    result.setCatalog(source.getCatalog());
                    if(source.getState()!=null){
                    Map<Integer,String> StateMap=new HashMap<>();
                        StateMap.put(1,"待支付");
                        StateMap.put(2,"待发货");
                        StateMap.put(3,"待收货");
                        StateMap.put(4,"待评价");
                        StateMap.put(5,"已完成");
                        StateMap.put(6,"已取消");
                    String label=  StateMap.get(source.getState());
                    result.setStateName(label);
                    }
                    result.setState(source.getState());
        return result;
    }

}

