package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.life.shop.api.apis.ShopStaffRoleApi;
import com.nbsaas.life.shop.data.entity.ShopStaffRole;
import com.nbsaas.life.shop.api.domain.request.ShopStaffRoleRequest;
import com.nbsaas.life.shop.api.domain.response.ShopStaffRoleResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopStaffRoleSimple;
import com.nbsaas.life.shop.rest.convert.ShopStaffRoleSimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopStaffRoleEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopStaffRoleResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopStaffRoleRepository;

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
public class ShopStaffRoleResource extends BaseResource<ShopStaffRole,ShopStaffRoleResponse, ShopStaffRoleSimple, ShopStaffRoleRequest>  implements ShopStaffRoleApi {

    @Resource
    private ShopStaffRoleRepository shopStaffRoleRepository;

    @Override
    public JpaRepositoryImplementation<ShopStaffRole, Serializable> getJpaRepository() {
        return shopStaffRoleRepository;
    }

    @Override
    public Function<ShopStaffRole, ShopStaffRoleSimple> getConvertSimple() {
        return new ShopStaffRoleSimpleConvert();
    }

    @Override
    public Function<ShopStaffRoleRequest, ShopStaffRole> getConvertForm() {
        return new ShopStaffRoleEntityConvert();
    }

    @Override
    public Function<ShopStaffRole, ShopStaffRoleResponse> getConvertResponse() {
    return new ShopStaffRoleResponseConvert();
    }




}


