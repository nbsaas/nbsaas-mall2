package com.nbsaas.life.user.rest.resource;

import com.nbsaas.life.user.api.apis.UserAccountApi;
import com.nbsaas.life.user.data.entity.UserAccount;
import com.nbsaas.life.user.api.domain.request.UserAccountDataRequest;
import com.nbsaas.life.user.api.domain.response.UserAccountResponse;
import com.nbsaas.life.user.api.domain.simple.UserAccountSimple;
import com.nbsaas.life.user.rest.convert.UserAccountSimpleConvert;
import com.nbsaas.life.user.rest.convert.UserAccountEntityConvert;
import com.nbsaas.life.user.rest.convert.UserAccountResponseConvert;
import com.nbsaas.life.user.data.repository.UserAccountRepository;

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
public class UserAccountResource extends BaseResource<UserAccount,UserAccountResponse, UserAccountSimple, UserAccountDataRequest>  implements UserAccountApi {

    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public JpaRepositoryImplementation<UserAccount, Serializable> getJpaRepository() {
        return userAccountRepository;
    }

    @Override
    public Function<UserAccount, UserAccountSimple> getConvertSimple() {
        return new UserAccountSimpleConvert();
    }

    @Override
    public Function<UserAccountDataRequest, UserAccount> getConvertForm() {
        return new UserAccountEntityConvert();
    }

    @Override
    public Function<UserAccount, UserAccountResponse> getConvertResponse() {
        return new UserAccountResponseConvert();
    }

}


