package com.nbsaas.life.user.rest.resource;

import com.nbsaas.life.user.api.apis.UserCityApi;
import com.nbsaas.life.user.data.entity.UserCity;
import com.nbsaas.life.user.api.domain.request.UserCityDataRequest;
import com.nbsaas.life.user.api.domain.response.UserCityResponse;
import com.nbsaas.life.user.api.domain.simple.UserCitySimple;
import com.nbsaas.life.user.rest.convert.UserCitySimpleConvert;
import com.nbsaas.life.user.rest.convert.UserCityEntityConvert;
import com.nbsaas.life.user.rest.convert.UserCityResponseConvert;
import com.nbsaas.life.user.data.repository.UserCityRepository;

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
public class UserCityResource extends BaseResource<UserCity,UserCityResponse, UserCitySimple, UserCityDataRequest>  implements UserCityApi {

    @Resource
    private UserCityRepository userCityRepository;

    @Override
    public JpaRepositoryImplementation<UserCity, Serializable> getJpaRepository() {
        return userCityRepository;
    }

    @Override
    public Function<UserCity, UserCitySimple> getConvertSimple() {
        return new UserCitySimpleConvert();
    }

    @Override
    public Function<UserCityDataRequest, UserCity> getConvertForm() {
        return new UserCityEntityConvert();
    }

    @Override
    public Function<UserCity, UserCityResponse> getConvertResponse() {
        return new UserCityResponseConvert();
    }

}


