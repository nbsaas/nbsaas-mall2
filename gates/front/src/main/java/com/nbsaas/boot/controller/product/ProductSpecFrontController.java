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
import com.nbsaas.boot.product.api.domain.request.ProductSpecRequest;
import com.nbsaas.boot.product.api.domain.request.ProductSpecSearch;
import com.nbsaas.boot.product.api.domain.response.ProductSpecResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductSpecSimple;
import com.nbsaas.boot.product.api.apis.ProductSpecApi;
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
@RequestMapping("/productSpec")
public class ProductSpecFrontController {


    @Resource
    private ProductSpecApi productSpecApi;


    @RequestMapping("/search")
    public PageResponse<ProductSpecSimple> search(ProductSpecSearch request) {
        return productSpecApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ProductSpecSimple> list(ProductSpecSearch request) {
        return productSpecApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ProductSpecResponse> create(@Validated(AddOperator.class) ProductSpecRequest request) {
        return productSpecApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ProductSpecResponse> update(@Validated(UpdateOperator.class) ProductSpecRequest request) {
        return productSpecApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductSpecRequest request) {
     return productSpecApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ProductSpecResponse> view(@Validated(ViewOperator.class) ProductSpecRequest request) {
        return productSpecApi.view(request);
    }
}