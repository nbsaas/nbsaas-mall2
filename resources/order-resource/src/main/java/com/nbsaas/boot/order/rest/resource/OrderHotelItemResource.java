package com.nbsaas.boot.order.rest.resource;

import com.nbsaas.boot.order.api.apis.OrderHotelItemApi;
import com.nbsaas.boot.order.data.entity.OrderHotelItem;
import com.nbsaas.boot.order.api.domain.request.OrderHotelItemRequest;
import com.nbsaas.boot.order.api.domain.response.OrderHotelItemResponse;
import com.nbsaas.boot.order.api.domain.simple.OrderHotelItemSimple;
import com.nbsaas.boot.order.rest.convert.OrderHotelItemSimpleConvert;
import com.nbsaas.boot.order.rest.convert.OrderHotelItemEntityConvert;
import com.nbsaas.boot.order.rest.convert.OrderHotelItemResponseConvert;
import com.nbsaas.boot.order.data.repository.OrderHotelItemRepository;

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
public class OrderHotelItemResource extends BaseResource<OrderHotelItem,OrderHotelItemResponse, OrderHotelItemSimple, OrderHotelItemRequest>  implements OrderHotelItemApi {

    @Resource
    private OrderHotelItemRepository orderHotelItemRepository;

    @Override
    public JpaRepositoryImplementation<OrderHotelItem, Serializable> getJpaRepository() {
        return orderHotelItemRepository;
    }

    @Override
    public Function<OrderHotelItem, OrderHotelItemSimple> getConvertSimple() {
        return new OrderHotelItemSimpleConvert();
    }

    @Override
    public Function<OrderHotelItemRequest, OrderHotelItem> getConvertForm() {
        return new OrderHotelItemEntityConvert();
    }

    @Override
    public Function<OrderHotelItem, OrderHotelItemResponse> getConvertResponse() {
        return new OrderHotelItemResponseConvert();
    }




}


