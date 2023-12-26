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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
*  前端控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/shopCategory")
public class ShopCategoryFrontController {


    @Resource
    private ShopCategoryApi shopCategoryApi;


    @RequestMapping("/search")
    public PageResponse<ShopCategorySimple> search(ShopCategorySearch request) {
        return shopCategoryApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopCategorySimple> list(ShopCategorySearch request) {
        return shopCategoryApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ShopCategoryResponse> create(@Validated(AddOperator.class) ShopCategoryRequest request) {
        return shopCategoryApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ShopCategoryResponse> update(@Validated(UpdateOperator.class) ShopCategoryRequest request) {
        return shopCategoryApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopCategoryRequest request) {
     return shopCategoryApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ShopCategoryResponse> view(@Validated(ViewOperator.class) ShopCategoryRequest request) {
        return shopCategoryApi.view(request);
    }
}