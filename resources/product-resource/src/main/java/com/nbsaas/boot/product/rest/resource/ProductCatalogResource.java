package com.nbsaas.boot.product.rest.resource;

import com.nbsaas.boot.product.api.apis.ProductCatalogApi;
import com.nbsaas.boot.product.data.entity.ProductCatalog;
import com.nbsaas.boot.product.api.domain.request.ProductCatalogRequest;
import com.nbsaas.boot.product.api.domain.response.ProductCatalogResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductCatalogSimple;
import com.nbsaas.boot.product.rest.convert.ProductCatalogSimpleConvert;
import com.nbsaas.boot.product.rest.convert.ProductCatalogEntityConvert;
import com.nbsaas.boot.product.rest.convert.ProductCatalogResponseConvert;
import com.nbsaas.boot.product.data.repository.ProductCatalogRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.product.api.domain.request.ProductCatalogSearch;
/**
*   业务接口实现
*/
@Transactional
@Service
public class ProductCatalogResource extends BaseResource<ProductCatalog,ProductCatalogResponse, ProductCatalogSimple, ProductCatalogRequest>  implements ProductCatalogApi {

    @Resource
    private ProductCatalogRepository productCatalogRepository;

    @Override
    public JpaRepositoryImplementation<ProductCatalog, Serializable> getJpaRepository() {
        return productCatalogRepository;
    }

    @Override
    public Function<ProductCatalog, ProductCatalogSimple> getConvertSimple() {
        return new ProductCatalogSimpleConvert();
    }

    @Override
    public Function<ProductCatalogRequest, ProductCatalog> getConvertForm() {
        return new ProductCatalogEntityConvert();
    }

    @Override
    public Function<ProductCatalog, ProductCatalogResponse> getConvertResponse() {
        return new ProductCatalogResponseConvert();
    }



    @Override
    public ListResponse<ProductCatalogSimple> list(PageRequest request) {
        ProductCatalogSimpleConvert convert=new ProductCatalogSimpleConvert();
        if (request instanceof ProductCatalogSearch){
             ProductCatalogSearch searchRequest=(ProductCatalogSearch)request;
             convert.setFetch(searchRequest.getFetch());
        }
        return listSimple(request,convert);
    }

}


