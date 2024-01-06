package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.ShopSearchWordApi;
import com.nbsaas.boot.shop.data.entity.ShopSearchWord;
import com.nbsaas.boot.shop.api.domain.request.ShopSearchWordRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopSearchWordResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopSearchWordSimple;
import com.nbsaas.boot.shop.rest.convert.ShopSearchWordSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.ShopSearchWordEntityConvert;
import com.nbsaas.boot.shop.rest.convert.ShopSearchWordResponseConvert;
import com.nbsaas.boot.shop.data.repository.ShopSearchWordRepository;

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
public class ShopSearchWordResource extends BaseResource<ShopSearchWord,ShopSearchWordResponse, ShopSearchWordSimple, ShopSearchWordRequest>  implements ShopSearchWordApi {

    @Resource
    private ShopSearchWordRepository shopSearchWordRepository;

    @Override
    public JpaRepositoryImplementation<ShopSearchWord, Serializable> getJpaRepository() {
        return shopSearchWordRepository;
    }

    @Override
    public Function<ShopSearchWord, ShopSearchWordSimple> getConvertSimple() {
        return new ShopSearchWordSimpleConvert();
    }

    @Override
    public Function<ShopSearchWordRequest, ShopSearchWord> getConvertForm() {
        return new ShopSearchWordEntityConvert();
    }

    @Override
    public Function<ShopSearchWord, ShopSearchWordResponse> getConvertResponse() {
        return new ShopSearchWordResponseConvert();
    }




}


