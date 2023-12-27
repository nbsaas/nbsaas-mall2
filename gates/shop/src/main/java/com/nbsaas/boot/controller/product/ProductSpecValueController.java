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
import com.nbsaas.boot.product.api.domain.request.ProductSpecValueRequest;
import com.nbsaas.boot.product.api.domain.request.ProductSpecValueSearch;
import com.nbsaas.boot.product.api.domain.response.ProductSpecValueResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductSpecValueSimple;
import com.nbsaas.boot.product.api.apis.ProductSpecValueApi;
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
@RequestMapping("/productSpecValue")
public class ProductSpecValueController {


    @Resource
    private ProductSpecValueApi productSpecValueApi;


    @RequiresPermissions("productSpecValue")
    @RequestMapping("/search")
    public PageResponse <ProductSpecValueSimple> search(ProductSpecValueSearch request) {
        return productSpecValueApi.search(request);
    }

    @RequiresPermissions("productSpecValue")
    @RequestMapping("/list")
    public ListResponse<ProductSpecValueSimple> list(ProductSpecValueSearch request) {
        return productSpecValueApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("productSpecValue")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ProductSpecValueResponse> create(@Validated(AddOperator.class) ProductSpecValueRequest request) {
        return productSpecValueApi.create(request);
    }

   @RequiresPermissions("productSpecValue")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ProductSpecValueResponse> update(@Validated(UpdateOperator.class) ProductSpecValueRequest request) {
       return productSpecValueApi.update(request);
   }

    @RequiresPermissions("productSpecValue")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductSpecValueRequest request) {
        return productSpecValueApi.delete(request);
    }

    @RequiresPermissions("productSpecValue")
    @RequestMapping("/view")
    public ResponseObject <ProductSpecValueResponse> view(@Validated(ViewOperator.class) ProductSpecValueRequest  request) {
        return productSpecValueApi.view(request);
    }
}