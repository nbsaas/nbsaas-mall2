package com.nbsaas.boot.controller.product;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.product.api.domain.request.ProductCatalogRequest;
import com.nbsaas.boot.product.api.domain.request.ProductCatalogSearch;
import com.nbsaas.boot.product.api.domain.response.ProductCatalogResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductCatalogSimple;
import com.nbsaas.boot.product.api.apis.ProductCatalogApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/productCatalog")
public class ProductCatalogController {


    @Resource
    private ProductCatalogApi productCatalogApi;


    @RequiresPermissions("productCatalog")
    @RequestMapping("/search")
    public PageResponse <ProductCatalogSimple> search(ProductCatalogSearch request) {
        return productCatalogApi.search(request);
    }

    @RequiresPermissions("productCatalog")
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
    @RequiresPermissions("productCatalog")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ProductCatalogResponse> create(@Validated(AddOperator.class) ProductCatalogRequest request) {
        return productCatalogApi.create(request);
    }

   @RequiresPermissions("productCatalog")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ProductCatalogResponse> update(@Validated(UpdateOperator.class) ProductCatalogRequest request) {
       return productCatalogApi.update(request);
   }

    @RequiresPermissions("productCatalog")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductCatalogRequest request) {
        return productCatalogApi.delete(request);
    }

    @RequiresPermissions("productCatalog")
    @RequestMapping("/view")
    public ResponseObject <ProductCatalogResponse> view(@Validated(ViewOperator.class) ProductCatalogRequest  request) {
        return productCatalogApi.view(request);
    }
}