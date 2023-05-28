package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.RoleMenuApi;
import com.nbsaas.life.system.data.entity.RoleMenu;
import com.nbsaas.life.system.api.domain.request.RoleMenuDataRequest;
import com.nbsaas.life.system.api.domain.response.RoleMenuResponse;
import com.nbsaas.life.system.api.domain.simple.RoleMenuSimple;
import com.nbsaas.life.system.rest.convert.RoleMenuSimpleConvert;
import com.nbsaas.life.system.rest.convert.RoleMenuEntityConvert;
import com.nbsaas.life.system.rest.convert.RoleMenuResponseConvert;
import com.nbsaas.life.system.data.repository.RoleMenuRepository;

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
public class RoleMenuResource extends BaseResource<RoleMenu,RoleMenuResponse, RoleMenuSimple, RoleMenuDataRequest>  implements RoleMenuApi {

    @Resource
    private RoleMenuRepository roleMenuRepository;

    @Override
    public JpaRepositoryImplementation<RoleMenu, Serializable> getJpaRepository() {
        return roleMenuRepository;
    }

    @Override
    public Function<RoleMenu, RoleMenuSimple> getConvertSimple() {
        return new RoleMenuSimpleConvert();
    }

    @Override
    public Function<RoleMenuDataRequest, RoleMenu> getConvertForm() {
        return new RoleMenuEntityConvert();
    }

    @Override
    public Function<RoleMenu, RoleMenuResponse> getConvertResponse() {
        return new RoleMenuResponseConvert();
    }

}


