package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.life.shop.api.apis.ShopImageApi;
import com.nbsaas.life.shop.data.entity.ShopImage;
import com.nbsaas.life.shop.api.domain.request.ShopImageDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopImageSearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopImageResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopImageSimple;
import com.nbsaas.life.shop.rest.convert.ShopImageSimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopImageEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopImageResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopImageRepository;

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
public class ShopImageResource extends BaseResource<ShopImage,ShopImageResponse, ShopImageSimple, ShopImageDataRequest>  implements ShopImageApi {

    @Resource
    private ShopImageRepository shopImageRepository;

    @Override
    public JpaRepositoryImplementation<ShopImage, Serializable> getJpaRepository() {
        return shopImageRepository;
    }

    @Override
    public Function<ShopImage, ShopImageSimple> getConvertSimple() {
        return new ShopImageSimpleConvert();
    }

    @Override
    public Function<ShopImageDataRequest, ShopImage> getConvertForm() {
        return new ShopImageEntityConvert();
    }

    @Override
    public Function<ShopImage, ShopImageResponse> getConvertResponse() {
    return new ShopImageResponseConvert();
    }




}


