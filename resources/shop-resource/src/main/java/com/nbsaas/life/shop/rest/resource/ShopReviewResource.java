package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.life.shop.api.apis.ShopReviewApi;
import com.nbsaas.life.shop.data.entity.ShopReview;
import com.nbsaas.life.shop.api.domain.request.ShopReviewRequest;
import com.nbsaas.life.shop.api.domain.response.ShopReviewResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopReviewSimple;
import com.nbsaas.life.shop.rest.convert.ShopReviewSimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopReviewEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopReviewResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopReviewRepository;

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
public class ShopReviewResource extends BaseResource<ShopReview,ShopReviewResponse, ShopReviewSimple, ShopReviewRequest>  implements ShopReviewApi {

    @Resource
    private ShopReviewRepository shopReviewRepository;

    @Override
    public JpaRepositoryImplementation<ShopReview, Serializable> getJpaRepository() {
        return shopReviewRepository;
    }

    @Override
    public Function<ShopReview, ShopReviewSimple> getConvertSimple() {
        return new ShopReviewSimpleConvert();
    }

    @Override
    public Function<ShopReviewRequest, ShopReview> getConvertForm() {
        return new ShopReviewEntityConvert();
    }

    @Override
    public Function<ShopReview, ShopReviewResponse> getConvertResponse() {
    return new ShopReviewResponseConvert();
    }




}


