package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.ApplicationMenuApi;
import com.nbsaas.life.system.data.entity.ApplicationMenu;
import com.nbsaas.life.system.api.domain.request.ApplicationMenuDataRequest;
import com.nbsaas.life.system.api.domain.response.ApplicationMenuResponse;
import com.nbsaas.life.system.api.domain.simple.ApplicationMenuSimple;
import com.nbsaas.life.system.rest.convert.ApplicationMenuSimpleConvert;
import com.nbsaas.life.system.rest.convert.ApplicationMenuEntityConvert;
import com.nbsaas.life.system.rest.convert.ApplicationMenuResponseConvert;
import com.nbsaas.life.system.data.repository.ApplicationMenuRepository;

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
public class ApplicationMenuResource extends BaseResource<ApplicationMenu,ApplicationMenuResponse, ApplicationMenuSimple, ApplicationMenuDataRequest>  implements ApplicationMenuApi {

    @Resource
    private ApplicationMenuRepository applicationMenuRepository;

    @Override
    public JpaRepositoryImplementation<ApplicationMenu, Serializable> getJpaRepository() {
        return applicationMenuRepository;
    }

    @Override
    public Function<ApplicationMenu, ApplicationMenuSimple> getConvertSimple() {
        return new ApplicationMenuSimpleConvert();
    }

    @Override
    public Function<ApplicationMenuDataRequest, ApplicationMenu> getConvertForm() {
        return new ApplicationMenuEntityConvert();
    }

    @Override
    public Function<ApplicationMenu, ApplicationMenuResponse> getConvertResponse() {
        return new ApplicationMenuResponseConvert();
    }

}


