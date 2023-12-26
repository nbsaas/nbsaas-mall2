package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.ShopImageApi;
import com.nbsaas.boot.shop.data.entity.ShopImage;
import com.nbsaas.boot.shop.api.domain.request.ShopImageRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopImageResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopImageSimple;
import com.nbsaas.boot.shop.rest.convert.ShopImageSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.ShopImageEntityConvert;
import com.nbsaas.boot.shop.rest.convert.ShopImageResponseConvert;
import com.nbsaas.boot.shop.data.repository.ShopImageRepository;

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
public class ShopImageResource extends BaseResource<ShopImage,ShopImageResponse, ShopImageSimple, ShopImageRequest>  implements ShopImageApi {

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
    public Function<ShopImageRequest, ShopImage> getConvertForm() {
        return new ShopImageEntityConvert();
    }

    @Override
    public Function<ShopImage, ShopImageResponse> getConvertResponse() {
    return new ShopImageResponseConvert();
    }




}


