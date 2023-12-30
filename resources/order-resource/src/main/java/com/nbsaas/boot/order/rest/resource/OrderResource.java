package com.nbsaas.boot.order.rest.resource;

import com.nbsaas.boot.order.api.apis.OrderApi;
import com.nbsaas.boot.order.data.entity.Order;
import com.nbsaas.boot.order.api.domain.request.OrderRequest;
import com.nbsaas.boot.order.api.domain.response.OrderResponse;
import com.nbsaas.boot.order.api.domain.simple.OrderSimple;
import com.nbsaas.boot.order.rest.convert.OrderSimpleConvert;
import com.nbsaas.boot.order.rest.convert.OrderEntityConvert;
import com.nbsaas.boot.order.rest.convert.OrderResponseConvert;
import com.nbsaas.boot.order.data.repository.OrderRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
/**
*   业务接口实现
*/
@Transactional
@Service
public class OrderResource extends BaseResource<Order,OrderResponse, OrderSimple, OrderRequest>  implements OrderApi {

    @Resource
    private OrderRepository orderRepository;

    @Override
    public JpaRepositoryImplementation<Order, Serializable> getJpaRepository() {
        return orderRepository;
    }

    @Override
    public Function<Order, OrderSimple> getConvertSimple() {
        return new OrderSimpleConvert();
    }

    @Override
    public Function<OrderRequest, Order> getConvertForm() {
        return new OrderEntityConvert();
    }

    @Override
    public Function<Order, OrderResponse> getConvertResponse() {
        return new OrderResponseConvert();
    }




}


