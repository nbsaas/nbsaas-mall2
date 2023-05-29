package com.nbsaas.life.ad.rest.resource;

import com.nbsaas.life.ad.api.apis.AdApi;
import com.nbsaas.life.ad.data.entity.Ad;
import com.nbsaas.life.ad.api.domain.request.AdDataRequest;
import com.nbsaas.life.ad.api.domain.response.AdResponse;
import com.nbsaas.life.ad.api.domain.simple.AdSimple;
import com.nbsaas.life.ad.rest.convert.AdSimpleConvert;
import com.nbsaas.life.ad.rest.convert.AdEntityConvert;
import com.nbsaas.life.ad.rest.convert.AdResponseConvert;
import com.nbsaas.life.ad.data.repository.AdRepository;

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
public class AdResource extends BaseResource<Ad,AdResponse, AdSimple, AdDataRequest>  implements AdApi {

    @Resource
    private AdRepository adRepository;

    @Override
    public JpaRepositoryImplementation<Ad, Serializable> getJpaRepository() {
        return adRepository;
    }

    @Override
    public Function<Ad, AdSimple> getConvertSimple() {
        return new AdSimpleConvert();
    }

    @Override
    public Function<AdDataRequest, Ad> getConvertForm() {
        return new AdEntityConvert();
    }

    @Override
    public Function<Ad, AdResponse> getConvertResponse() {
        return new AdResponseConvert();
    }

}


