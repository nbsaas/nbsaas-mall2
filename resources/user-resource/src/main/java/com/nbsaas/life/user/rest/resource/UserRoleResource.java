package com.nbsaas.life.user.rest.resource;

import com.nbsaas.life.user.api.apis.UserRoleApi;
import com.nbsaas.life.user.data.entity.UserRole;
import com.nbsaas.life.user.api.domain.request.UserRoleDataRequest;
import com.nbsaas.life.user.api.domain.response.UserRoleResponse;
import com.nbsaas.life.user.api.domain.simple.UserRoleSimple;
import com.nbsaas.life.user.rest.convert.UserRoleSimpleConvert;
import com.nbsaas.life.user.rest.convert.UserRoleEntityConvert;
import com.nbsaas.life.user.rest.convert.UserRoleResponseConvert;
import com.nbsaas.life.user.data.repository.UserRoleRepository;

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
public class UserRoleResource extends BaseResource<UserRole,UserRoleResponse, UserRoleSimple, UserRoleDataRequest>  implements UserRoleApi {

    @Resource
    private UserRoleRepository userRoleRepository;

    @Override
    public JpaRepositoryImplementation<UserRole, Serializable> getJpaRepository() {
        return userRoleRepository;
    }

    @Override
    public Function<UserRole, UserRoleSimple> getConvertSimple() {
        return new UserRoleSimpleConvert();
    }

    @Override
    public Function<UserRoleDataRequest, UserRole> getConvertForm() {
        return new UserRoleEntityConvert();
    }

    @Override
    public Function<UserRole, UserRoleResponse> getConvertResponse() {
        return new UserRoleResponseConvert();
    }

}


