package com.nbsaas.life.product.rest.resource;

import com.nbsaas.life.product.api.apis.ProductSkuApi;
import com.nbsaas.life.product.data.entity.ProductSku;
import com.nbsaas.life.product.api.domain.request.ProductSkuRequest;
import com.nbsaas.life.product.api.domain.response.ProductSkuResponse;
import com.nbsaas.life.product.api.domain.simple.ProductSkuSimple;
import com.nbsaas.life.product.rest.convert.ProductSkuSimpleConvert;
import com.nbsaas.life.product.rest.convert.ProductSkuEntityConvert;
import com.nbsaas.life.product.rest.convert.ProductSkuResponseConvert;
import com.nbsaas.life.product.data.repository.ProductSkuRepository;

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
public class ProductSkuResource extends BaseResource<ProductSku,ProductSkuResponse, ProductSkuSimple, ProductSkuRequest>  implements ProductSkuApi {

    @Resource
    private ProductSkuRepository productSkuRepository;

    @Override
    public JpaRepositoryImplementation<ProductSku, Serializable> getJpaRepository() {
        return productSkuRepository;
    }

    @Override
    public Function<ProductSku, ProductSkuSimple> getConvertSimple() {
        return new ProductSkuSimpleConvert();
    }

    @Override
    public Function<ProductSkuRequest, ProductSku> getConvertForm() {
        return new ProductSkuEntityConvert();
    }

    @Override
    public Function<ProductSku, ProductSkuResponse> getConvertResponse() {
    return new ProductSkuResponseConvert();
    }




}


