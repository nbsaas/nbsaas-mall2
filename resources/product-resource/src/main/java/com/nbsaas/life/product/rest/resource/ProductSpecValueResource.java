package com.nbsaas.life.product.rest.resource;

import com.nbsaas.life.product.api.apis.ProductSpecValueApi;
import com.nbsaas.life.product.data.entity.ProductSpecValue;
import com.nbsaas.life.product.api.domain.request.ProductSpecValueRequest;
import com.nbsaas.life.product.api.domain.response.ProductSpecValueResponse;
import com.nbsaas.life.product.api.domain.simple.ProductSpecValueSimple;
import com.nbsaas.life.product.rest.convert.ProductSpecValueSimpleConvert;
import com.nbsaas.life.product.rest.convert.ProductSpecValueEntityConvert;
import com.nbsaas.life.product.rest.convert.ProductSpecValueResponseConvert;
import com.nbsaas.life.product.data.repository.ProductSpecValueRepository;

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
public class ProductSpecValueResource extends BaseResource<ProductSpecValue,ProductSpecValueResponse, ProductSpecValueSimple, ProductSpecValueRequest>  implements ProductSpecValueApi {

    @Resource
    private ProductSpecValueRepository productSpecValueRepository;

    @Override
    public JpaRepositoryImplementation<ProductSpecValue, Serializable> getJpaRepository() {
        return productSpecValueRepository;
    }

    @Override
    public Function<ProductSpecValue, ProductSpecValueSimple> getConvertSimple() {
        return new ProductSpecValueSimpleConvert();
    }

    @Override
    public Function<ProductSpecValueRequest, ProductSpecValue> getConvertForm() {
        return new ProductSpecValueEntityConvert();
    }

    @Override
    public Function<ProductSpecValue, ProductSpecValueResponse> getConvertResponse() {
    return new ProductSpecValueResponseConvert();
    }




}


