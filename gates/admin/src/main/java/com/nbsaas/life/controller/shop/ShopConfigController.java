package com.nbsaas.life.controller.shop;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.life.shop.api.domain.request.ShopConfigRequest;
import com.nbsaas.life.shop.api.domain.request.ShopConfigSearch;
import com.nbsaas.life.shop.api.domain.response.ShopConfigResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopConfigSimple;
import com.nbsaas.life.shop.api.apis.ShopConfigApi;
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
@RequestMapping("/shopConfig")
public class ShopConfigController {


    @Resource
    private ShopConfigApi shopConfigApi;


    @RequiresPermissions("shopConfig")
    @RequestMapping("/search")
    public PageResponse <ShopConfigSimple> search(ShopConfigSearch request) {
        return shopConfigApi.search(request);
    }

    @RequiresPermissions("shopConfig")
    @RequestMapping("/list")
    public ListResponse<ShopConfigSimple> list(ShopConfigSearch request) {
        return shopConfigApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopConfig")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopConfigResponse> create(@Validated(AddOperator.class) ShopConfigRequest request) {
        return shopConfigApi.create(request);
    }

   @RequiresPermissions("shopConfig")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopConfigResponse> update(@Validated(UpdateOperator.class) ShopConfigRequest request) {
       return shopConfigApi.update(request);
   }

    @RequiresPermissions("shopConfig")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopConfigRequest request) {
        return shopConfigApi.delete(request);
    }

    @RequiresPermissions("shopConfig")
    @RequestMapping("/view")
    public ResponseObject <ShopConfigResponse> view(@Validated(ViewOperator.class) ShopConfigRequest  request) {
        return shopConfigApi.view(request);
    }
}