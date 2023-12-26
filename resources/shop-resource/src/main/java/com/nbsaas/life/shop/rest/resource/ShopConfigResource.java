package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.life.shop.api.apis.ShopConfigApi;
import com.nbsaas.life.shop.data.entity.ShopConfig;
import com.nbsaas.life.shop.api.domain.request.ShopConfigRequest;
import com.nbsaas.life.shop.api.domain.response.ShopConfigResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopConfigSimple;
import com.nbsaas.life.shop.rest.convert.ShopConfigSimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopConfigEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopConfigResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopConfigRepository;

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
public class ShopConfigResource extends BaseResource<ShopConfig,ShopConfigResponse, ShopConfigSimple, ShopConfigRequest>  implements ShopConfigApi {

    @Resource
    private ShopConfigRepository shopConfigRepository;

    @Override
    public JpaRepositoryImplementation<ShopConfig, Serializable> getJpaRepository() {
        return shopConfigRepository;
    }

    @Override
    public Function<ShopConfig, ShopConfigSimple> getConvertSimple() {
        return new ShopConfigSimpleConvert();
    }

    @Override
    public Function<ShopConfigRequest, ShopConfig> getConvertForm() {
        return new ShopConfigEntityConvert();
    }

    @Override
    public Function<ShopConfig, ShopConfigResponse> getConvertResponse() {
    return new ShopConfigResponseConvert();
    }




}


