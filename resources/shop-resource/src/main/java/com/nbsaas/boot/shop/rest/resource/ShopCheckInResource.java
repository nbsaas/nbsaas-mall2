package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.ShopCheckInApi;
import com.nbsaas.boot.shop.data.entity.ShopCheckIn;
import com.nbsaas.boot.shop.api.domain.request.ShopCheckInRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopCheckInResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopCheckInSimple;
import com.nbsaas.boot.shop.rest.convert.ShopCheckInSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.ShopCheckInEntityConvert;
import com.nbsaas.boot.shop.rest.convert.ShopCheckInResponseConvert;
import com.nbsaas.boot.shop.data.repository.ShopCheckInRepository;

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
public class ShopCheckInResource extends BaseResource<ShopCheckIn,ShopCheckInResponse, ShopCheckInSimple, ShopCheckInRequest>  implements ShopCheckInApi {

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
    public Function<ShopCheckInRequest, ShopCheckIn> getConvertForm() {
        return new ShopCheckInEntityConvert();
    }

    @Override
    public Function<ShopCheckIn, ShopCheckInResponse> getConvertResponse() {
    return new ShopCheckInResponseConvert();
    }




}


