package com.nbsaas.life.controller.shop;

import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.shop.api.apis.ShopCategoryApi;
import com.nbsaas.life.shop.api.domain.request.ShopCategoryDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopCategorySearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopCategoryResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopCategorySimple;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 */
@RestController
@RequestMapping("/shopCategory")
public class ShopCategoryFrontController {


    @Resource
    private ShopCategoryApi shopCategoryApi;


    @RequestMapping("/search")
    public PageResponse<ShopCategorySimple> search(ShopCategorySearchRequest request) {
        return shopCategoryApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopCategorySimple> list(ShopCategorySearchRequest request) {
        return shopCategoryApi.list(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ShopCategoryResponse> view(@Validated(ViewOperator.class) ShopCategoryDataRequest request) {
        return shopCategoryApi.view(request);
    }
}
