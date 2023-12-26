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
import com.nbsaas.boot.shop.api.domain.request.ShopCategoryRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopCategorySearch;
import com.nbsaas.boot.shop.api.domain.response.ShopCategoryResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopCategorySimple;
import com.nbsaas.boot.shop.api.apis.ShopCategoryApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RestController
@RequestMapping("/shopCategory")
public class ShopCategoryController {


    @Resource
    private ShopCategoryApi shopCategoryApi;

    @Cacheable("shop")
    @RequestMapping("/search")
    public PageResponse <ShopCategorySimple> search(ShopCategorySearch request) {
        return shopCategoryApi.search(request);
    }

    @Cacheable("shop")
    @RequestMapping("/list")
    public ListResponse<ShopCategorySimple> list(ShopCategorySearch request) {
        return shopCategoryApi.list(request);
    }




    @RequestMapping("/view")
    public ResponseObject <ShopCategoryResponse> view(@Validated(ViewOperator.class) ShopCategoryRequest  request) {
        return shopCategoryApi.view(request);
    }
}