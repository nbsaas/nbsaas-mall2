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
import com.nbsaas.boot.shop.api.domain.request.ShopCheckInRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopCheckInSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopCheckInResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopCheckInSimple;
import com.nbsaas.boot.shop.api.apis.ShopCheckInApi;
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
@RequestMapping("/shopCheckIn")
public class ShopCheckInController {


    @Resource
    private ShopCheckInApi shopCheckInApi;


    @RequiresPermissions("shopCheckIn")
    @RequestMapping("/search")
    public PageResponse <ShopCheckInSimple> search(ShopCheckInSearch request) {
        return shopCheckInApi.search(request);
    }

    @RequiresPermissions("shopCheckIn")
    @RequestMapping("/list")
    public ListResponse<ShopCheckInSimple> list(ShopCheckInSearch request) {
        return shopCheckInApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopCheckIn")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopCheckInResponse> create(@Validated(AddOperator.class) ShopCheckInRequest request) {
        return shopCheckInApi.create(request);
    }

   @RequiresPermissions("shopCheckIn")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopCheckInResponse> update(@Validated(UpdateOperator.class) ShopCheckInRequest request) {
       return shopCheckInApi.update(request);
   }

    @RequiresPermissions("shopCheckIn")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopCheckInRequest request) {
        return shopCheckInApi.delete(request);
    }

    @RequiresPermissions("shopCheckIn")
    @RequestMapping("/view")
    public ResponseObject <ShopCheckInResponse> view(@Validated(ViewOperator.class) ShopCheckInRequest  request) {
        return shopCheckInApi.view(request);
    }
}