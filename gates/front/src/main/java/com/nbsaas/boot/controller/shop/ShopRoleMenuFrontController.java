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
import com.nbsaas.boot.shop.api.domain.request.ShopRoleMenuRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopRoleMenuSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopRoleMenuResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopRoleMenuSimple;
import com.nbsaas.boot.shop.api.apis.ShopRoleMenuApi;
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
@RequestMapping("/shopRoleMenu")
public class ShopRoleMenuFrontController {


    @Resource
    private ShopRoleMenuApi shopRoleMenuApi;


    @RequestMapping("/search")
    public PageResponse<ShopRoleMenuSimple> search(ShopRoleMenuSearch request) {
        return shopRoleMenuApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopRoleMenuSimple> list(ShopRoleMenuSearch request) {
        return shopRoleMenuApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ShopRoleMenuResponse> create(@Validated(AddOperator.class) ShopRoleMenuRequest request) {
        return shopRoleMenuApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ShopRoleMenuResponse> update(@Validated(UpdateOperator.class) ShopRoleMenuRequest request) {
        return shopRoleMenuApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopRoleMenuRequest request) {
     return shopRoleMenuApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ShopRoleMenuResponse> view(@Validated(ViewOperator.class) ShopRoleMenuRequest request) {
        return shopRoleMenuApi.view(request);
    }
}