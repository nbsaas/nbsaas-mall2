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
import com.nbsaas.boot.product.api.domain.request.ProductRequest;
import com.nbsaas.boot.product.api.domain.request.ProductSearch;
import com.nbsaas.boot.product.api.domain.response.ProductResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductSimple;
import com.nbsaas.boot.product.api.apis.ProductApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import com.nbsaas.boot.rest.enums.StoreState;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/product")
public class ProductController {


    @Resource
    private ProductApi productApi;


    @RequiresPermissions("product")
    @RequestMapping("/search")
    public PageResponse <ProductSimple> search(ProductSearch request) {
            request.setStoreState(StoreState.normal);
        return productApi.search(request);
    }

    @RequiresPermissions("product")
    @RequestMapping("/list")
    public ListResponse<ProductSimple> list(ProductSearch request) {
            request.setStoreState(StoreState.normal);
        return productApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("product")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ProductResponse> create(@Validated(AddOperator.class) ProductRequest request) {
        return productApi.create(request);
    }

   @RequiresPermissions("product")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ProductResponse> update(@Validated(UpdateOperator.class) ProductRequest request) {
       return productApi.update(request);
   }

    @RequiresPermissions("product")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductRequest request) {
        return productApi.delete(request);
    }

    @RequiresPermissions("product")
    @RequestMapping("/view")
    public ResponseObject <ProductResponse> view(@Validated(ViewOperator.class) ProductRequest  request) {
        return productApi.view(request);
    }
}