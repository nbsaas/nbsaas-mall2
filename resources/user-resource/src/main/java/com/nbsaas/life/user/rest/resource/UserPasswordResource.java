package com.nbsaas.life.user.rest.resource;

import com.nbsaas.life.user.api.apis.UserPasswordApi;
import com.nbsaas.life.user.data.entity.UserPassword;
import com.nbsaas.life.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.life.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.life.user.api.domain.simple.UserPasswordSimple;
import com.nbsaas.life.user.rest.convert.UserPasswordSimpleConvert;
import com.nbsaas.life.user.rest.convert.UserPasswordEntityConvert;
import com.nbsaas.life.user.rest.convert.UserPasswordResponseConvert;
import com.nbsaas.life.user.data.repository.UserPasswordRepository;

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
public class UserPasswordResource extends BaseResource<UserPassword,UserPasswordResponse, UserPasswordSimple, UserPasswordDataRequest>  implements UserPasswordApi {

    @Resource
    private UserPasswordRepository userPasswordRepository;

    @Override
    public JpaRepositoryImplementation<UserPassword, Serializable> getJpaRepository() {
        return userPasswordRepository;
    }

    @Override
    public Function<UserPassword, UserPasswordSimple> getConvertSimple() {
        return new UserPasswordSimpleConvert();
    }

    @Override
    public Function<UserPasswordDataRequest, UserPassword> getConvertForm() {
        return new UserPasswordEntityConvert();
    }

    @Override
    public Function<UserPassword, UserPasswordResponse> getConvertResponse() {
        return new UserPasswordResponseConvert();
    }

}


