package com.nbsaas.boot.product.rest.resource;

import com.nbsaas.boot.product.api.apis.ProductApi;
import com.nbsaas.boot.product.data.entity.Product;
import com.nbsaas.boot.product.api.domain.request.ProductRequest;
import com.nbsaas.boot.product.api.domain.response.ProductResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductSimple;
import com.nbsaas.boot.product.rest.convert.ProductSimpleConvert;
import com.nbsaas.boot.product.rest.convert.ProductEntityConvert;
import com.nbsaas.boot.product.rest.convert.ProductResponseConvert;
import com.nbsaas.boot.product.data.repository.ProductRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.request.RequestId;
import java.util.Optional;
import com.nbsaas.boot.rest.response.ResponseObject;
/**
*   业务接口实现
*/
@Transactional
@Service
public class ProductResource extends BaseResource<Product,ProductResponse, ProductSimple, ProductRequest>  implements ProductApi {

    @Resource
    private ProductRepository productRepository;

    @Override
    public JpaRepositoryImplementation<Product, Serializable> getJpaRepository() {
        return productRepository;
    }

    @Override
    public Function<Product, ProductSimple> getConvertSimple() {
        return new ProductSimpleConvert();
    }

    @Override
    public Function<ProductRequest, Product> getConvertForm() {
        return new ProductEntityConvert();
    }

    @Override
    public Function<Product, ProductResponse> getConvertResponse() {
        return new ProductResponseConvert();
    }




    @Override
    public ResponseObject<ProductResponse> create(ProductRequest request) {
        request.setStoreState(StoreState.normal);
        return super.create(request);
   }

    @Override
    public ResponseObject<?> delete(RequestId request) {

        ResponseObject<?> result = new ResponseObject<>();
        Optional<Product> optional = getJpaRepository().findById(request.getId());
        if (!optional.isPresent()) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Product bean = optional.get();
        bean.setStoreState(StoreState.draft);
        return result;

    }
}


