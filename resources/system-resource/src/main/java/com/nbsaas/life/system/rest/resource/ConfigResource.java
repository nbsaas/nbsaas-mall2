package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.ConfigApi;
import com.nbsaas.life.system.data.entity.Config;
import com.nbsaas.life.system.api.domain.request.ConfigDataRequest;
import com.nbsaas.life.system.api.domain.response.ConfigResponse;
import com.nbsaas.life.system.api.domain.simple.ConfigSimple;
import com.nbsaas.life.system.rest.convert.ConfigSimpleConvert;
import com.nbsaas.life.system.rest.convert.ConfigEntityConvert;
import com.nbsaas.life.system.rest.convert.ConfigResponseConvert;
import com.nbsaas.life.system.data.repository.ConfigRepository;

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
public class ConfigResource extends BaseResource<Config,ConfigResponse, ConfigSimple, ConfigDataRequest>  implements ConfigApi {

    @Resource
    private ConfigRepository configRepository;

    @Override
    public JpaRepositoryImplementation<Config, Serializable> getJpaRepository() {
        return configRepository;
    }

    @Override
    public Function<Config, ConfigSimple> getConvertSimple() {
        return new ConfigSimpleConvert();
    }

    @Override
    public Function<ConfigDataRequest, Config> getConvertForm() {
        return new ConfigEntityConvert();
    }

    @Override
    public Function<Config, ConfigResponse> getConvertResponse() {
        return new ConfigResponseConvert();
    }

}


