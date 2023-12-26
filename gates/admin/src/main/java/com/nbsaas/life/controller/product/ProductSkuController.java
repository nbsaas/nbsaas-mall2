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
import com.nbsaas.life.product.api.domain.request.ProductSkuRequest;
import com.nbsaas.life.product.api.domain.request.ProductSkuSearch;
import com.nbsaas.life.product.api.domain.response.ProductSkuResponse;
import com.nbsaas.life.product.api.domain.simple.ProductSkuSimple;
import com.nbsaas.life.product.api.apis.ProductSkuApi;
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
@RequestMapping("/productSku")
public class ProductSkuController {


    @Resource
    private ProductSkuApi productSkuApi;


    @RequiresPermissions("productSku")
    @RequestMapping("/search")
    public PageResponse <ProductSkuSimple> search(ProductSkuSearch request) {
        return productSkuApi.search(request);
    }

    @RequiresPermissions("productSku")
    @RequestMapping("/list")
    public ListResponse<ProductSkuSimple> list(ProductSkuSearch request) {
        return productSkuApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("productSku")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ProductSkuResponse> create(@Validated(AddOperator.class) ProductSkuRequest request) {
        return productSkuApi.create(request);
    }

   @RequiresPermissions("productSku")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ProductSkuResponse> update(@Validated(UpdateOperator.class) ProductSkuRequest request) {
       return productSkuApi.update(request);
   }

    @RequiresPermissions("productSku")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductSkuRequest request) {
        return productSkuApi.delete(request);
    }

    @RequiresPermissions("productSku")
    @RequestMapping("/view")
    public ResponseObject <ProductSkuResponse> view(@Validated(ViewOperator.class) ProductSkuRequest  request) {
        return productSkuApi.view(request);
    }
}