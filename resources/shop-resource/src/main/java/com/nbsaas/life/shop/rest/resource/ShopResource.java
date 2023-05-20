package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.life.shop.api.apis.ShopApi;
import com.nbsaas.life.shop.data.entity.Shop;
import com.nbsaas.life.shop.api.domain.request.ShopDataRequest;
import com.nbsaas.life.shop.api.domain.response.ShopResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopSimple;
import com.nbsaas.life.shop.rest.convert.ShopSimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopRepository;

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
public class ShopResource extends BaseResource<Shop,ShopResponse, ShopSimple, ShopDataRequest>  implements ShopApi {

    @Resource
    private ShopRepository shopRepository;

    @Override
    public JpaRepositoryImplementation<Shop, Serializable> getJpaRepository() {
        return shopRepository;
    }

    @Override
    public Function<Shop, ShopSimple> getConvertSimple() {
        return new ShopSimpleConvert();
    }

    @Override
    public Function<ShopDataRequest, Shop> getConvertForm() {
        return new ShopEntityConvert();
    }

    @Override
    public Function<Shop, ShopResponse> getConvertResponse() {
        return new ShopResponseConvert();
    }

}


