package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.life.shop.api.apis.ShopCategoryApi;
import com.nbsaas.life.shop.data.entity.ShopCategory;
import com.nbsaas.life.shop.api.domain.request.ShopCategoryDataRequest;
import com.nbsaas.life.shop.api.domain.response.ShopCategoryResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopCategorySimple;
import com.nbsaas.life.shop.rest.convert.ShopCategorySimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopCategoryEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopCategoryResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopCategoryRepository;

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
public class ShopCategoryResource extends BaseResource<ShopCategory,ShopCategoryResponse, ShopCategorySimple, ShopCategoryDataRequest>  implements ShopCategoryApi {

    @Resource
    private ShopCategoryRepository shopCategoryRepository;

    @Override
    public JpaRepositoryImplementation<ShopCategory, Serializable> getJpaRepository() {
        return shopCategoryRepository;
    }

    @Override
    public Function<ShopCategory, ShopCategorySimple> getConvertSimple() {
        return new ShopCategorySimpleConvert();
    }

    @Override
    public Function<ShopCategoryDataRequest, ShopCategory> getConvertForm() {
        return new ShopCategoryEntityConvert();
    }

    @Override
    public Function<ShopCategory, ShopCategoryResponse> getConvertResponse() {
        return new ShopCategoryResponseConvert();
    }

}


