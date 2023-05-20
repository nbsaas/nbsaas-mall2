package com.nbsaas.life.user.rest.resource;

import com.nbsaas.life.user.api.apis.UserInfoApi;
import com.nbsaas.life.user.data.entity.UserInfo;
import com.nbsaas.life.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.life.user.api.domain.response.UserInfoResponse;
import com.nbsaas.life.user.api.domain.simple.UserInfoSimple;
import com.nbsaas.life.user.rest.convert.UserInfoSimpleConvert;
import com.nbsaas.life.user.rest.convert.UserInfoEntityConvert;
import com.nbsaas.life.user.rest.convert.UserInfoResponseConvert;
import com.nbsaas.life.user.data.repository.UserInfoRepository;

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
public class UserInfoResource extends BaseResource<UserInfo,UserInfoResponse, UserInfoSimple, UserInfoDataRequest>  implements UserInfoApi {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public JpaRepositoryImplementation<UserInfo, Serializable> getJpaRepository() {
        return userInfoRepository;
    }

    @Override
    public Function<UserInfo, UserInfoSimple> getConvertSimple() {
        return new UserInfoSimpleConvert();
    }

    @Override
    public Function<UserInfoDataRequest, UserInfo> getConvertForm() {
        return new UserInfoEntityConvert();
    }

    @Override
    public Function<UserInfo, UserInfoResponse> getConvertResponse() {
        return new UserInfoResponseConvert();
    }

}


