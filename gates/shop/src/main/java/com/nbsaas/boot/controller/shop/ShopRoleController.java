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
import com.nbsaas.boot.shop.api.domain.request.ShopRoleRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopRoleSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopRoleResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopRoleSimple;
import com.nbsaas.boot.shop.api.apis.ShopRoleApi;
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
@RequestMapping("/shopRole")
public class ShopRoleController {


    @Resource
    private ShopRoleApi shopRoleApi;


    @RequiresPermissions("shopRole")
    @RequestMapping("/search")
    public PageResponse <ShopRoleSimple> search(ShopRoleSearch request) {
        return shopRoleApi.search(request);
    }

    @RequiresPermissions("shopRole")
    @RequestMapping("/list")
    public ListResponse<ShopRoleSimple> list(ShopRoleSearch request) {
        return shopRoleApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopRole")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopRoleResponse> create(@Validated(AddOperator.class) ShopRoleRequest request) {
        return shopRoleApi.create(request);
    }

   @RequiresPermissions("shopRole")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopRoleResponse> update(@Validated(UpdateOperator.class) ShopRoleRequest request) {
       return shopRoleApi.update(request);
   }

    @RequiresPermissions("shopRole")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopRoleRequest request) {
        return shopRoleApi.delete(request);
    }

    @RequiresPermissions("shopRole")
    @RequestMapping("/view")
    public ResponseObject <ShopRoleResponse> view(@Validated(ViewOperator.class) ShopRoleRequest  request) {
        return shopRoleApi.view(request);
    }
}