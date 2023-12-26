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
@RequestMapping("/shopRoleMenu")
public class ShopRoleMenuController {


    @Resource
    private ShopRoleMenuApi shopRoleMenuApi;


    @RequiresPermissions("shopRoleMenu")
    @RequestMapping("/search")
    public PageResponse <ShopRoleMenuSimple> search(ShopRoleMenuSearch request) {
        return shopRoleMenuApi.search(request);
    }

    @RequiresPermissions("shopRoleMenu")
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
    @RequiresPermissions("shopRoleMenu")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopRoleMenuResponse> create(@Validated(AddOperator.class) ShopRoleMenuRequest request) {
        return shopRoleMenuApi.create(request);
    }

   @RequiresPermissions("shopRoleMenu")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopRoleMenuResponse> update(@Validated(UpdateOperator.class) ShopRoleMenuRequest request) {
       return shopRoleMenuApi.update(request);
   }

    @RequiresPermissions("shopRoleMenu")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopRoleMenuRequest request) {
        return shopRoleMenuApi.delete(request);
    }

    @RequiresPermissions("shopRoleMenu")
    @RequestMapping("/view")
    public ResponseObject <ShopRoleMenuResponse> view(@Validated(ViewOperator.class) ShopRoleMenuRequest  request) {
        return shopRoleMenuApi.view(request);
    }
}