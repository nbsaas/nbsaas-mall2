package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.RoleApi;
import com.nbsaas.life.system.data.entity.Role;
import com.nbsaas.life.system.api.domain.request.RoleDataRequest;
import com.nbsaas.life.system.api.domain.response.RoleResponse;
import com.nbsaas.life.system.api.domain.simple.RoleSimple;
import com.nbsaas.life.system.rest.convert.RoleSimpleConvert;
import com.nbsaas.life.system.rest.convert.RoleEntityConvert;
import com.nbsaas.life.system.rest.convert.RoleResponseConvert;
import com.nbsaas.life.system.data.repository.RoleRepository;

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
public class RoleResource extends BaseResource<Role,RoleResponse, RoleSimple, RoleDataRequest>  implements RoleApi {

    @Resource
    private RoleRepository roleRepository;

    @Override
    public JpaRepositoryImplementation<Role, Serializable> getJpaRepository() {
        return roleRepository;
    }

    @Override
    public Function<Role, RoleSimple> getConvertSimple() {
        return new RoleSimpleConvert();
    }

    @Override
    public Function<RoleDataRequest, Role> getConvertForm() {
        return new RoleEntityConvert();
    }

    @Override
    public Function<Role, RoleResponse> getConvertResponse() {
        return new RoleResponseConvert();
    }

}


