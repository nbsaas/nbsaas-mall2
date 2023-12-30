package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.ShopTagApi;
import com.nbsaas.boot.shop.data.entity.ShopTag;
import com.nbsaas.boot.shop.api.domain.request.ShopTagRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopTagResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopTagSimple;
import com.nbsaas.boot.shop.rest.convert.ShopTagSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.ShopTagEntityConvert;
import com.nbsaas.boot.shop.rest.convert.ShopTagResponseConvert;
import com.nbsaas.boot.shop.data.repository.ShopTagRepository;

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
public class ShopTagResource extends BaseResource<ShopTag,ShopTagResponse, ShopTagSimple, ShopTagRequest>  implements ShopTagApi {

    @Resource
    private ShopTagRepository shopTagRepository;

    @Override
    public JpaRepositoryImplementation<ShopTag, Serializable> getJpaRepository() {
        return shopTagRepository;
    }

    @Override
    public Function<ShopTag, ShopTagSimple> getConvertSimple() {
        return new ShopTagSimpleConvert();
    }

    @Override
    public Function<ShopTagRequest, ShopTag> getConvertForm() {
        return new ShopTagEntityConvert();
    }

    @Override
    public Function<ShopTag, ShopTagResponse> getConvertResponse() {
        return new ShopTagResponseConvert();
    }




}


