package com.nbsaas.boot.ad.rest.resource;

import com.nbsaas.boot.ad.api.apis.AdPositionApi;
import com.nbsaas.boot.ad.data.entity.AdPosition;
import com.nbsaas.boot.ad.api.domain.request.AdPositionRequest;
import com.nbsaas.boot.ad.api.domain.response.AdPositionResponse;
import com.nbsaas.boot.ad.api.domain.simple.AdPositionSimple;
import com.nbsaas.boot.ad.rest.convert.AdPositionSimpleConvert;
import com.nbsaas.boot.ad.rest.convert.AdPositionEntityConvert;
import com.nbsaas.boot.ad.rest.convert.AdPositionResponseConvert;
import com.nbsaas.boot.ad.data.repository.AdPositionRepository;

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
public class AdPositionResource extends BaseResource<AdPosition,AdPositionResponse, AdPositionSimple, AdPositionRequest>  implements AdPositionApi {

    @Resource
    private AdPositionRepository adPositionRepository;

    @Override
    public JpaRepositoryImplementation<AdPosition, Serializable> getJpaRepository() {
        return adPositionRepository;
    }

    @Override
    public Function<AdPosition, AdPositionSimple> getConvertSimple() {
        return new AdPositionSimpleConvert();
    }

    @Override
    public Function<AdPositionRequest, AdPosition> getConvertForm() {
        return new AdPositionEntityConvert();
    }

    @Override
    public Function<AdPosition, AdPositionResponse> getConvertResponse() {
    return new AdPositionResponseConvert();
    }




}


