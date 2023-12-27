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
import com.nbsaas.boot.product.api.domain.request.BrandRequest;
import com.nbsaas.boot.product.api.domain.request.BrandSearch;
import com.nbsaas.boot.product.api.domain.response.BrandResponse;
import com.nbsaas.boot.product.api.domain.simple.BrandSimple;
import com.nbsaas.boot.product.api.apis.BrandApi;
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
@RequestMapping("/brand")
public class BrandController {


    @Resource
    private BrandApi brandApi;


    @RequiresPermissions("brand")
    @RequestMapping("/search")
    public PageResponse <BrandSimple> search(BrandSearch request) {
            request.setStoreState(StoreState.normal);
        return brandApi.search(request);
    }

    @RequiresPermissions("brand")
    @RequestMapping("/list")
    public ListResponse<BrandSimple> list(BrandSearch request) {
            request.setStoreState(StoreState.normal);
        return brandApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("brand")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <BrandResponse> create(@Validated(AddOperator.class) BrandRequest request) {
        return brandApi.create(request);
    }

   @RequiresPermissions("brand")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<BrandResponse> update(@Validated(UpdateOperator.class) BrandRequest request) {
       return brandApi.update(request);
   }

    @RequiresPermissions("brand")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) BrandRequest request) {
        return brandApi.delete(request);
    }

    @RequiresPermissions("brand")
    @RequestMapping("/view")
    public ResponseObject <BrandResponse> view(@Validated(ViewOperator.class) BrandRequest  request) {
        return brandApi.view(request);
    }
}