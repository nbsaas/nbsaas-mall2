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
import com.nbsaas.life.product.api.domain.request.BrandRequest;
import com.nbsaas.life.product.api.domain.request.BrandSearch;
import com.nbsaas.life.product.api.domain.response.BrandResponse;
import com.nbsaas.life.product.api.domain.simple.BrandSimple;
import com.nbsaas.life.product.api.apis.BrandApi;
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
@RequestMapping("/brand")
public class BrandFrontController {


    @Resource
    private BrandApi brandApi;


    @RequestMapping("/search")
    public PageResponse<BrandSimple> search(BrandSearch request) {
        return brandApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<BrandSimple> list(BrandSearch request) {
        return brandApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<BrandResponse> create(@Validated(AddOperator.class) BrandRequest request) {
        return brandApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <BrandResponse> update(@Validated(UpdateOperator.class) BrandRequest request) {
        return brandApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) BrandRequest request) {
     return brandApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<BrandResponse> view(@Validated(ViewOperator.class) BrandRequest request) {
        return brandApi.view(request);
    }
}