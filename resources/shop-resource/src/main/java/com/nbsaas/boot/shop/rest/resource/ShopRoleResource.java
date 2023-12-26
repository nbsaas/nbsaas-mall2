package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.ShopRoleApi;
import com.nbsaas.boot.shop.data.entity.ShopRole;
import com.nbsaas.boot.shop.api.domain.request.ShopRoleRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopRoleResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopRoleSimple;
import com.nbsaas.boot.shop.rest.convert.ShopRoleSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.ShopRoleEntityConvert;
import com.nbsaas.boot.shop.rest.convert.ShopRoleResponseConvert;
import com.nbsaas.boot.shop.data.repository.ShopRoleRepository;

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
public class ShopRoleResource extends BaseResource<ShopRole,ShopRoleResponse, ShopRoleSimple, ShopRoleRequest>  implements ShopRoleApi {

    @Resource
    private ShopRoleRepository shopRoleRepository;

    @Override
    public JpaRepositoryImplementation<ShopRole, Serializable> getJpaRepository() {
        return shopRoleRepository;
    }

    @Override
    public Function<ShopRole, ShopRoleSimple> getConvertSimple() {
        return new ShopRoleSimpleConvert();
    }

    @Override
    public Function<ShopRoleRequest, ShopRole> getConvertForm() {
        return new ShopRoleEntityConvert();
    }

    @Override
    public Function<ShopRole, ShopRoleResponse> getConvertResponse() {
    return new ShopRoleResponseConvert();
    }




}


