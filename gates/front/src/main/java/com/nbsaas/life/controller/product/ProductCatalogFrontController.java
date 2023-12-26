package com.nbsaas.life.controller.product;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.life.product.api.domain.request.ProductCatalogRequest;
import com.nbsaas.life.product.api.domain.request.ProductCatalogSearch;
import com.nbsaas.life.product.api.domain.response.ProductCatalogResponse;
import com.nbsaas.life.product.api.domain.simple.ProductCatalogSimple;
import com.nbsaas.life.product.api.apis.ProductCatalogApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
*  前端控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/productCatalog")
public class ProductCatalogFrontController {


    @Resource
    private ProductCatalogApi productCatalogApi;


    @RequestMapping("/search")
    public PageResponse<ProductCatalogSimple> search(ProductCatalogSearch request) {
        return productCatalogApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ProductCatalogSimple> list(ProductCatalogSearch request) {
        return productCatalogApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ProductCatalogResponse> create(@Validated(AddOperator.class) ProductCatalogRequest request) {
        return productCatalogApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ProductCatalogResponse> update(@Validated(UpdateOperator.class) ProductCatalogRequest request) {
        return productCatalogApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductCatalogRequest request) {
     return productCatalogApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ProductCatalogResponse> view(@Validated(ViewOperator.class) ProductCatalogRequest request) {
        return productCatalogApi.view(request);
    }
}