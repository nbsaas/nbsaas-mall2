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
import com.nbsaas.life.product.api.domain.request.ProductSpecValueRequest;
import com.nbsaas.life.product.api.domain.request.ProductSpecValueSearch;
import com.nbsaas.life.product.api.domain.response.ProductSpecValueResponse;
import com.nbsaas.life.product.api.domain.simple.ProductSpecValueSimple;
import com.nbsaas.life.product.api.apis.ProductSpecValueApi;
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
@RequestMapping("/productSpecValue")
public class ProductSpecValueFrontController {


    @Resource
    private ProductSpecValueApi productSpecValueApi;


    @RequestMapping("/search")
    public PageResponse<ProductSpecValueSimple> search(ProductSpecValueSearch request) {
        return productSpecValueApi.search(request);
    }

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
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ProductSpecValueResponse> create(@Validated(AddOperator.class) ProductSpecValueRequest request) {
        return productSpecValueApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ProductSpecValueResponse> update(@Validated(UpdateOperator.class) ProductSpecValueRequest request) {
        return productSpecValueApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductSpecValueRequest request) {
     return productSpecValueApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ProductSpecValueResponse> view(@Validated(ViewOperator.class) ProductSpecValueRequest request) {
        return productSpecValueApi.view(request);
    }
}