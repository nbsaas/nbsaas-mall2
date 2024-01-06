package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.ShopHotWordApi;
import com.nbsaas.boot.shop.data.entity.ShopHotWord;
import com.nbsaas.boot.shop.api.domain.request.ShopHotWordRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopHotWordResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopHotWordSimple;
import com.nbsaas.boot.shop.rest.convert.ShopHotWordSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.ShopHotWordEntityConvert;
import com.nbsaas.boot.shop.rest.convert.ShopHotWordResponseConvert;
import com.nbsaas.boot.shop.data.repository.ShopHotWordRepository;

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
public class ShopHotWordResource extends BaseResource<ShopHotWord,ShopHotWordResponse, ShopHotWordSimple, ShopHotWordRequest>  implements ShopHotWordApi {

    @Resource
    private ShopHotWordRepository shopHotWordRepository;

    @Override
    public JpaRepositoryImplementation<ShopHotWord, Serializable> getJpaRepository() {
        return shopHotWordRepository;
    }

    @Override
    public Function<ShopHotWord, ShopHotWordSimple> getConvertSimple() {
        return new ShopHotWordSimpleConvert();
    }

    @Override
    public Function<ShopHotWordRequest, ShopHotWord> getConvertForm() {
        return new ShopHotWordEntityConvert();
    }

    @Override
    public Function<ShopHotWord, ShopHotWordResponse> getConvertResponse() {
        return new ShopHotWordResponseConvert();
    }




}


