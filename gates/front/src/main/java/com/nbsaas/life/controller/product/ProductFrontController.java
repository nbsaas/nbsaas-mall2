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
import com.nbsaas.life.product.api.domain.request.ProductRequest;
import com.nbsaas.life.product.api.domain.request.ProductSearch;
import com.nbsaas.life.product.api.domain.response.ProductResponse;
import com.nbsaas.life.product.api.domain.simple.ProductSimple;
import com.nbsaas.life.product.api.apis.ProductApi;
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
@RequestMapping("/product")
public class ProductFrontController {


    @Resource
    private ProductApi productApi;


    @RequestMapping("/search")
    public PageResponse<ProductSimple> search(ProductSearch request) {
        return productApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ProductSimple> list(ProductSearch request) {
        return productApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ProductResponse> create(@Validated(AddOperator.class) ProductRequest request) {
        return productApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ProductResponse> update(@Validated(UpdateOperator.class) ProductRequest request) {
        return productApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductRequest request) {
     return productApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ProductResponse> view(@Validated(ViewOperator.class) ProductRequest request) {
        return productApi.view(request);
    }
}