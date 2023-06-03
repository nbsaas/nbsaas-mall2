package com.nbsaas.life.system.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.life.system.api.apis.DictApi;
import com.nbsaas.life.system.api.domain.request.DictDataRequest;
import com.nbsaas.life.system.api.domain.response.DictResponse;
import com.nbsaas.life.system.api.domain.simple.DictSimple;
import com.nbsaas.life.system.data.entity.Dict;
import com.nbsaas.life.system.data.repository.DictRepository;
import com.nbsaas.life.system.rest.convert.DictEntityConvert;
import com.nbsaas.life.system.rest.convert.DictResponseConvert;
import com.nbsaas.life.system.rest.convert.DictSimpleConvert;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class DictResource extends BaseResource<Dict, DictResponse, DictSimple, DictDataRequest> implements DictApi {

    @Resource
    private DictRepository dictRepository;

    @Override
    public JpaRepositoryImplementation<Dict, Serializable> getJpaRepository() {
        return dictRepository;
    }

    @Override
    public Function<Dict, DictSimple> getConvertSimple() {
        return new DictSimpleConvert();
    }

    @Override
    public Function
            <DictDataRequest, Dict> getConvertForm() {
        return new DictEntityConvert();
    }

    @Override
    public Function<Dict, DictResponse> getConvertResponse() {
        return new DictResponseConvert();
    }

}


