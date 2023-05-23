package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.ApplicationApi;
import com.nbsaas.life.system.data.entity.Application;
import com.nbsaas.life.system.api.domain.request.ApplicationDataRequest;
import com.nbsaas.life.system.api.domain.response.ApplicationResponse;
import com.nbsaas.life.system.api.domain.simple.ApplicationSimple;
import com.nbsaas.life.system.rest.convert.ApplicationSimpleConvert;
import com.nbsaas.life.system.rest.convert.ApplicationEntityConvert;
import com.nbsaas.life.system.rest.convert.ApplicationResponseConvert;
import com.nbsaas.life.system.data.repository.ApplicationRepository;

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
public class ApplicationResource extends BaseResource<Application,ApplicationResponse, ApplicationSimple, ApplicationDataRequest>  implements ApplicationApi {

    @Resource
    private ApplicationRepository applicationRepository;

    @Override
    public JpaRepositoryImplementation<Application, Serializable> getJpaRepository() {
        return applicationRepository;
    }

    @Override
    public Function<Application, ApplicationSimple> getConvertSimple() {
        return new ApplicationSimpleConvert();
    }

    @Override
    public Function<ApplicationDataRequest, Application> getConvertForm() {
        return new ApplicationEntityConvert();
    }

    @Override
    public Function<Application, ApplicationResponse> getConvertResponse() {
        return new ApplicationResponseConvert();
    }

}


