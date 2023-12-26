package com.nbsaas.life.product.rest.resource;

import com.nbsaas.life.product.api.apis.BrandApi;
import com.nbsaas.life.product.data.entity.Brand;
import com.nbsaas.life.product.api.domain.request.BrandRequest;
import com.nbsaas.life.product.api.domain.response.BrandResponse;
import com.nbsaas.life.product.api.domain.simple.BrandSimple;
import com.nbsaas.life.product.rest.convert.BrandSimpleConvert;
import com.nbsaas.life.product.rest.convert.BrandEntityConvert;
import com.nbsaas.life.product.rest.convert.BrandResponseConvert;
import com.nbsaas.life.product.data.repository.BrandRepository;

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
public class BrandResource extends BaseResource<Brand,BrandResponse, BrandSimple, BrandRequest>  implements BrandApi {

    @Resource
    private BrandRepository brandRepository;

    @Override
    public JpaRepositoryImplementation<Brand, Serializable> getJpaRepository() {
        return brandRepository;
    }

    @Override
    public Function<Brand, BrandSimple> getConvertSimple() {
        return new BrandSimpleConvert();
    }

    @Override
    public Function<BrandRequest, Brand> getConvertForm() {
        return new BrandEntityConvert();
    }

    @Override
    public Function<Brand, BrandResponse> getConvertResponse() {
    return new BrandResponseConvert();
    }




}


