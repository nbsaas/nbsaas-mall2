package com.nbsaas.boot.ad.rest.resource;

import com.nbsaas.boot.ad.api.apis.AdApi;
import com.nbsaas.boot.ad.data.entity.Ad;
import com.nbsaas.boot.ad.api.domain.request.AdRequest;
import com.nbsaas.boot.ad.api.domain.response.AdResponse;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;
import com.nbsaas.boot.ad.rest.convert.AdSimpleConvert;
import com.nbsaas.boot.ad.rest.convert.AdEntityConvert;
import com.nbsaas.boot.ad.rest.convert.AdResponseConvert;
import com.nbsaas.boot.ad.data.repository.AdRepository;

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
public class AdResource extends BaseResource<Ad,AdResponse, AdSimple, AdRequest>  implements AdApi {

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
    public Function<AdRequest, Ad> getConvertForm() {
        return new AdEntityConvert();
    }

    @Override
    public Function<Ad, AdResponse> getConvertResponse() {
    return new AdResponseConvert();
    }




}


