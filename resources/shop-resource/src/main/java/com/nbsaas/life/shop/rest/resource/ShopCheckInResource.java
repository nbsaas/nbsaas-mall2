package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.life.shop.api.apis.ShopCheckInApi;
import com.nbsaas.life.shop.data.entity.ShopCheckIn;
import com.nbsaas.life.shop.api.domain.request.ShopCheckInDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopCheckInSearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopCheckInResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopCheckInSimple;
import com.nbsaas.life.shop.rest.convert.ShopCheckInSimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopCheckInEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopCheckInResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopCheckInRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class ShopCheckInResource extends BaseResource<ShopCheckIn,ShopCheckInResponse, ShopCheckInSimple, ShopCheckInDataRequest>  implements ShopCheckInApi {

    @Resource
    private ShopCheckInRepository shopCheckInRepository;

    @Override
    public JpaRepositoryImplementation<ShopCheckIn, Serializable> getJpaRepository() {
        return shopCheckInRepository;
    }

    @Override
    public Function<ShopCheckIn, ShopCheckInSimple> getConvertSimple() {
        return new ShopCheckInSimpleConvert();
    }

    @Override
    public Function<ShopCheckInDataRequest, ShopCheckIn> getConvertForm() {
        return new ShopCheckInEntityConvert();
    }

    @Override
    public Function<ShopCheckIn, ShopCheckInResponse> getConvertResponse() {
    return new ShopCheckInResponseConvert();
    }




}


