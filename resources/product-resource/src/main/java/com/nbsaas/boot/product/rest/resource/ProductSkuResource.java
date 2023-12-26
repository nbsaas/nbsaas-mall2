package com.nbsaas.boot.product.rest.resource;

import com.nbsaas.boot.product.api.apis.ProductSkuApi;
import com.nbsaas.boot.product.data.entity.ProductSku;
import com.nbsaas.boot.product.api.domain.request.ProductSkuRequest;
import com.nbsaas.boot.product.api.domain.response.ProductSkuResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductSkuSimple;
import com.nbsaas.boot.product.rest.convert.ProductSkuSimpleConvert;
import com.nbsaas.boot.product.rest.convert.ProductSkuEntityConvert;
import com.nbsaas.boot.product.rest.convert.ProductSkuResponseConvert;
import com.nbsaas.boot.product.data.repository.ProductSkuRepository;

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


