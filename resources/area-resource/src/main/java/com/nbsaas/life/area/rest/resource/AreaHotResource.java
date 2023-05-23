package com.nbsaas.life.area.rest.resource;

import com.nbsaas.life.area.api.apis.AreaHotApi;
import com.nbsaas.life.area.data.entity.AreaHot;
import com.nbsaas.life.area.api.domain.request.AreaHotDataRequest;
import com.nbsaas.life.area.api.domain.response.AreaHotResponse;
import com.nbsaas.life.area.api.domain.simple.AreaHotSimple;
import com.nbsaas.life.area.rest.convert.AreaHotSimpleConvert;
import com.nbsaas.life.area.rest.convert.AreaHotEntityConvert;
import com.nbsaas.life.area.rest.convert.AreaHotResponseConvert;
import com.nbsaas.life.area.data.repository.AreaHotRepository;

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
public class AreaHotResource extends BaseResource<AreaHot,AreaHotResponse, AreaHotSimple, AreaHotDataRequest>  implements AreaHotApi {

    @Resource
    private AreaHotRepository areaHotRepository;

    @Override
    public JpaRepositoryImplementation<AreaHot, Serializable> getJpaRepository() {
        return areaHotRepository;
    }

    @Override
    public Function<AreaHot, AreaHotSimple> getConvertSimple() {
        return new AreaHotSimpleConvert();
    }

    @Override
    public Function<AreaHotDataRequest, AreaHot> getConvertForm() {
        return new AreaHotEntityConvert();
    }

    @Override
    public Function<AreaHot, AreaHotResponse> getConvertResponse() {
        return new AreaHotResponseConvert();
    }

}


