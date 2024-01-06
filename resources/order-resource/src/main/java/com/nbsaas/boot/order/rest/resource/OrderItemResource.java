package com.nbsaas.boot.order.rest.resource;

import com.nbsaas.boot.order.api.apis.OrderItemApi;
import com.nbsaas.boot.order.data.entity.OrderItem;
import com.nbsaas.boot.order.api.domain.request.OrderItemRequest;
import com.nbsaas.boot.order.api.domain.response.OrderItemResponse;
import com.nbsaas.boot.order.api.domain.simple.OrderItemSimple;
import com.nbsaas.boot.order.rest.convert.OrderItemSimpleConvert;
import com.nbsaas.boot.order.rest.convert.OrderItemEntityConvert;
import com.nbsaas.boot.order.rest.convert.OrderItemResponseConvert;
import com.nbsaas.boot.order.data.repository.OrderItemRepository;

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
public class OrderItemResource extends BaseResource<OrderItem,OrderItemResponse, OrderItemSimple, OrderItemRequest>  implements OrderItemApi {

    @Resource
    private OrderItemRepository orderItemRepository;

    @Override
    public JpaRepositoryImplementation<OrderItem, Serializable> getJpaRepository() {
        return orderItemRepository;
    }

    @Override
    public Function<OrderItem, OrderItemSimple> getConvertSimple() {
        return new OrderItemSimpleConvert();
    }

    @Override
    public Function<OrderItemRequest, OrderItem> getConvertForm() {
        return new OrderItemEntityConvert();
    }

    @Override
    public Function<OrderItem, OrderItemResponse> getConvertResponse() {
        return new OrderItemResponseConvert();
    }




}


