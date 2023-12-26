package com.nbsaas.boot.area.rest.resource;

import com.nbsaas.boot.area.api.apis.AreaHotApi;
import com.nbsaas.boot.area.data.entity.AreaHot;
import com.nbsaas.boot.area.api.domain.request.AreaHotRequest;
import com.nbsaas.boot.area.api.domain.response.AreaHotResponse;
import com.nbsaas.boot.area.api.domain.simple.AreaHotSimple;
import com.nbsaas.boot.area.rest.convert.AreaHotSimpleConvert;
import com.nbsaas.boot.area.rest.convert.AreaHotEntityConvert;
import com.nbsaas.boot.area.rest.convert.AreaHotResponseConvert;
import com.nbsaas.boot.area.data.repository.AreaHotRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
/**
*   业务接口实现
*/
@Transactional
@Service
public class AreaHotResource extends BaseResource<AreaHot,AreaHotResponse, AreaHotSimple, AreaHotRequest>  implements AreaHotApi {

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
    public Function<AreaHotRequest, AreaHot> getConvertForm() {
        return new AreaHotEntityConvert();
    }

    @Override
    public Function<AreaHot, AreaHotResponse> getConvertResponse() {
    return new AreaHotResponseConvert();
    }




}


