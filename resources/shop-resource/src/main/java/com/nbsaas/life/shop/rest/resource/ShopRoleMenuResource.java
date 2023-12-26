package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.life.shop.api.apis.ShopRoleMenuApi;
import com.nbsaas.life.shop.data.entity.ShopRoleMenu;
import com.nbsaas.life.shop.api.domain.request.ShopRoleMenuRequest;
import com.nbsaas.life.shop.api.domain.response.ShopRoleMenuResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopRoleMenuSimple;
import com.nbsaas.life.shop.rest.convert.ShopRoleMenuSimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopRoleMenuEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopRoleMenuResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopRoleMenuRepository;

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
public class ShopRoleMenuResource extends BaseResource<ShopRoleMenu,ShopRoleMenuResponse, ShopRoleMenuSimple, ShopRoleMenuRequest>  implements ShopRoleMenuApi {

    @Resource
    private ShopRoleMenuRepository shopRoleMenuRepository;

    @Override
    public JpaRepositoryImplementation<ShopRoleMenu, Serializable> getJpaRepository() {
        return shopRoleMenuRepository;
    }

    @Override
    public Function<ShopRoleMenu, ShopRoleMenuSimple> getConvertSimple() {
        return new ShopRoleMenuSimpleConvert();
    }

    @Override
    public Function<ShopRoleMenuRequest, ShopRoleMenu> getConvertForm() {
        return new ShopRoleMenuEntityConvert();
    }

    @Override
    public Function<ShopRoleMenu, ShopRoleMenuResponse> getConvertResponse() {
    return new ShopRoleMenuResponseConvert();
    }




}


