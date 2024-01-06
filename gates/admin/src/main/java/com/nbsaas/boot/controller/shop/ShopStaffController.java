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
import com.nbsaas.boot.shop.api.domain.request.ShopStaffRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopStaffSimple;
import com.nbsaas.boot.shop.api.apis.ShopStaffApi;
import com.nbsaas.boot.shop.ext.apis.ShopStaffExtApi;
import com.nbsaas.boot.shop.ext.domain.request.ShopStaffExtRequest;
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
@RequestMapping("/shopStaff")
public class ShopStaffController {


    @Resource
    private ShopStaffApi shopStaffApi;

    @Resource
    private ShopStaffExtApi shopStaffExtApi;


    @RequiresPermissions("shopStaff")
    @RequestMapping("/search")
    public PageResponse <ShopStaffSimple> search(ShopStaffSearch request) {
        return shopStaffApi.search(request);
    }

    @RequiresPermissions("shopStaff")
    @RequestMapping("/list")
    public ListResponse<ShopStaffSimple> list(ShopStaffSearch request) {
        return shopStaffApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopStaff")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <?> create(@Validated(AddOperator.class) ShopStaffExtRequest request) {
        return shopStaffExtApi.create(request);
    }

   @RequiresPermissions("shopStaff")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopStaffResponse> update(@Validated(UpdateOperator.class) ShopStaffRequest request) {
       return shopStaffApi.update(request);
   }

    @RequiresPermissions("shopStaff")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopStaffRequest request) {
        return shopStaffApi.delete(request);
    }

    @RequiresPermissions("shopStaff")
    @RequestMapping("/view")
    public ResponseObject <ShopStaffResponse> view(@Validated(ViewOperator.class) ShopStaffRequest  request) {
        return shopStaffApi.view(request);
    }
}