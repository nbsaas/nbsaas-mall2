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
import com.nbsaas.boot.product.api.domain.request.ProductSkuRequest;
import com.nbsaas.boot.product.api.domain.request.ProductSkuSearch;
import com.nbsaas.boot.product.api.domain.response.ProductSkuResponse;
import com.nbsaas.boot.product.api.domain.simple.ProductSkuSimple;
import com.nbsaas.boot.product.api.apis.ProductSkuApi;
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
@RequestMapping("/productSku")
public class ProductSkuFrontController {


    @Resource
    private ProductSkuApi productSkuApi;


    @RequestMapping("/search")
    public PageResponse<ProductSkuSimple> search(ProductSkuSearch request) {
        return productSkuApi.search(request);
    }

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
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ProductSkuResponse> create(@Validated(AddOperator.class) ProductSkuRequest request) {
        return productSkuApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ProductSkuResponse> update(@Validated(UpdateOperator.class) ProductSkuRequest request) {
        return productSkuApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ProductSkuRequest request) {
     return productSkuApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ProductSkuResponse> view(@Validated(ViewOperator.class) ProductSkuRequest request) {
        return productSkuApi.view(request);
    }
}