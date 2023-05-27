package com.nbsaas.life.user.rest.resource;

import com.nbsaas.life.user.api.apis.UserLoginLogApi;
import com.nbsaas.life.user.data.entity.UserLoginLog;
import com.nbsaas.life.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.life.user.api.domain.response.UserLoginLogResponse;
import com.nbsaas.life.user.api.domain.simple.UserLoginLogSimple;
import com.nbsaas.life.user.rest.convert.UserLoginLogSimpleConvert;
import com.nbsaas.life.user.rest.convert.UserLoginLogEntityConvert;
import com.nbsaas.life.user.rest.convert.UserLoginLogResponseConvert;
import com.nbsaas.life.user.data.repository.UserLoginLogRepository;

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
public class UserLoginLogResource extends BaseResource<UserLoginLog,UserLoginLogResponse, UserLoginLogSimple, UserLoginLogDataRequest>  implements UserLoginLogApi {

    @Resource
    private UserLoginLogRepository userLoginLogRepository;

    @Override
    public JpaRepositoryImplementation<UserLoginLog, Serializable> getJpaRepository() {
        return userLoginLogRepository;
    }

    @Override
    public Function<UserLoginLog, UserLoginLogSimple> getConvertSimple() {
        return new UserLoginLogSimpleConvert();
    }

    @Override
    public Function<UserLoginLogDataRequest, UserLoginLog> getConvertForm() {
        return new UserLoginLogEntityConvert();
    }

    @Override
    public Function<UserLoginLog, UserLoginLogResponse> getConvertResponse() {
        return new UserLoginLogResponseConvert();
    }

}


