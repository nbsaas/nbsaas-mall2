package com.nbsaas.life.user.rest.resource;

import com.nbsaas.life.user.api.apis.UserOauthConfigApi;
import com.nbsaas.life.user.data.entity.UserOauthConfig;
import com.nbsaas.life.user.api.domain.request.UserOauthConfigDataRequest;
import com.nbsaas.life.user.api.domain.response.UserOauthConfigResponse;
import com.nbsaas.life.user.api.domain.simple.UserOauthConfigSimple;
import com.nbsaas.life.user.rest.convert.UserOauthConfigSimpleConvert;
import com.nbsaas.life.user.rest.convert.UserOauthConfigEntityConvert;
import com.nbsaas.life.user.rest.convert.UserOauthConfigResponseConvert;
import com.nbsaas.life.user.data.repository.UserOauthConfigRepository;

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
public class UserOauthConfigResource extends BaseResource<UserOauthConfig,UserOauthConfigResponse, UserOauthConfigSimple, UserOauthConfigDataRequest>  implements UserOauthConfigApi {

    @Resource
    private UserOauthConfigRepository userOauthConfigRepository;

    @Override
    public JpaRepositoryImplementation<UserOauthConfig, Serializable> getJpaRepository() {
        return userOauthConfigRepository;
    }

    @Override
    public Function<UserOauthConfig, UserOauthConfigSimple> getConvertSimple() {
        return new UserOauthConfigSimpleConvert();
    }

    @Override
    public Function<UserOauthConfigDataRequest, UserOauthConfig> getConvertForm() {
        return new UserOauthConfigEntityConvert();
    }

    @Override
    public Function<UserOauthConfig, UserOauthConfigResponse> getConvertResponse() {
        return new UserOauthConfigResponseConvert();
    }

}


