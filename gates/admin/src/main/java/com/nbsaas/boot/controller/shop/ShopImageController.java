package com.nbsaas.boot.controller.shop;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.shop.api.domain.request.ShopImageRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopImageSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopImageResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopImageSimple;
import com.nbsaas.boot.shop.api.apis.ShopImageApi;
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
@RequestMapping("/shopImage")
public class ShopImageController {


    @Resource
    private ShopImageApi shopImageApi;


    @RequiresPermissions("shopImage")
    @RequestMapping("/search")
    public PageResponse <ShopImageSimple> search(ShopImageSearch request) {
        return shopImageApi.search(request);
    }

    @RequiresPermissions("shopImage")
    @RequestMapping("/list")
    public ListResponse<ShopImageSimple> list(ShopImageSearch request) {
        return shopImageApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopImage")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopImageResponse> create(@Validated(AddOperator.class) ShopImageRequest request) {
        return shopImageApi.create(request);
    }

   @RequiresPermissions("shopImage")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopImageResponse> update(@Validated(UpdateOperator.class) ShopImageRequest request) {
       return shopImageApi.update(request);
   }

    @RequiresPermissions("shopImage")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopImageRequest request) {
        return shopImageApi.delete(request);
    }

    @RequiresPermissions("shopImage")
    @RequestMapping("/view")
    public ResponseObject <ShopImageResponse> view(@Validated(ViewOperator.class) ShopImageRequest  request) {
        return shopImageApi.view(request);
    }
}