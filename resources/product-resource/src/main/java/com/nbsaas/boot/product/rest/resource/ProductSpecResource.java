package com.nbsaas.boot.product.rest.resource;

import com.nbsaas.boot.product.api.apis.ProductSpecApi;
import com.nbsaas.boot.product.data.entity.ProductSpec;
import com.nbsaas.boot.product.api.domain.request.ProductSpecRequest;
import com.nbsaas.boot.product.api.domain.response.ProductSpecResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductSpecSimple;
import com.nbsaas.boot.product.rest.convert.ProductSpecSimpleConvert;
import com.nbsaas.boot.product.rest.convert.ProductSpecEntityConvert;
import com.nbsaas.boot.product.rest.convert.ProductSpecResponseConvert;
import com.nbsaas.boot.product.data.repository.ProductSpecRepository;

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
public class ProductSpecResource extends BaseResource<ProductSpec,ProductSpecResponse, ProductSpecSimple, ProductSpecRequest>  implements ProductSpecApi {

    @Resource
    private ProductSpecRepository productSpecRepository;

    @Override
    public JpaRepositoryImplementation<ProductSpec, Serializable> getJpaRepository() {
        return productSpecRepository;
    }

    @Override
    public Function<ProductSpec, ProductSpecSimple> getConvertSimple() {
        return new ProductSpecSimpleConvert();
    }

    @Override
    public Function<ProductSpecRequest, ProductSpec> getConvertForm() {
        return new ProductSpecEntityConvert();
    }

    @Override
    public Function<ProductSpec, ProductSpecResponse> getConvertResponse() {
    return new ProductSpecResponseConvert();
    }




}


