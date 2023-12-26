package com.nbsaas.boot.product.rest.resource;

import com.nbsaas.boot.product.api.apis.ProductSpecValueApi;
import com.nbsaas.boot.product.data.entity.ProductSpecValue;
import com.nbsaas.boot.product.api.domain.request.ProductSpecValueRequest;
import com.nbsaas.boot.product.api.domain.response.ProductSpecValueResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductSpecValueSimple;
import com.nbsaas.boot.product.rest.convert.ProductSpecValueSimpleConvert;
import com.nbsaas.boot.product.rest.convert.ProductSpecValueEntityConvert;
import com.nbsaas.boot.product.rest.convert.ProductSpecValueResponseConvert;
import com.nbsaas.boot.product.data.repository.ProductSpecValueRepository;

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


