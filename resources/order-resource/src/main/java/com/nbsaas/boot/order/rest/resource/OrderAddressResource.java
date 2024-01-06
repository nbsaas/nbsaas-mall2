package com.nbsaas.boot.order.rest.resource;

import com.nbsaas.boot.order.api.apis.OrderAddressApi;
import com.nbsaas.boot.order.data.entity.OrderAddress;
import com.nbsaas.boot.order.api.domain.request.OrderAddressRequest;
import com.nbsaas.boot.order.api.domain.response.OrderAddressResponse;
import com.nbsaas.boot.order.api.domain.simple.OrderAddressSimple;
import com.nbsaas.boot.order.rest.convert.OrderAddressSimpleConvert;
import com.nbsaas.boot.order.rest.convert.OrderAddressEntityConvert;
import com.nbsaas.boot.order.rest.convert.OrderAddressResponseConvert;
import com.nbsaas.boot.order.data.repository.OrderAddressRepository;

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
public class OrderAddressResource extends BaseResource<OrderAddress,OrderAddressResponse, OrderAddressSimple, OrderAddressRequest>  implements OrderAddressApi {

    @Resource
    private OrderAddressRepository orderAddressRepository;

    @Override
    public JpaRepositoryImplementation<OrderAddress, Serializable> getJpaRepository() {
        return orderAddressRepository;
    }

    @Override
    public Function<OrderAddress, OrderAddressSimple> getConvertSimple() {
        return new OrderAddressSimpleConvert();
    }

    @Override
    public Function<OrderAddressRequest, OrderAddress> getConvertForm() {
        return new OrderAddressEntityConvert();
    }

    @Override
    public Function<OrderAddress, OrderAddressResponse> getConvertResponse() {
        return new OrderAddressResponseConvert();
    }




}


