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
import com.nbsaas.boot.shop.api.domain.request.ShopHotWordRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopHotWordSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopHotWordResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopHotWordSimple;
import com.nbsaas.boot.shop.api.apis.ShopHotWordApi;
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
@RequestMapping("/shopHotWord")
public class ShopHotWordController {


    @Resource
    private ShopHotWordApi shopHotWordApi;


    @RequiresPermissions("shopHotWord")
    @RequestMapping("/search")
    public PageResponse <ShopHotWordSimple> search(ShopHotWordSearch request) {
        return shopHotWordApi.search(request);
    }

    @RequiresPermissions("shopHotWord")
    @RequestMapping("/list")
    public ListResponse<ShopHotWordSimple> list(ShopHotWordSearch request) {
        return shopHotWordApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopHotWord")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopHotWordResponse> create(@Validated(AddOperator.class) ShopHotWordRequest request) {
        return shopHotWordApi.create(request);
    }

   @RequiresPermissions("shopHotWord")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopHotWordResponse> update(@Validated(UpdateOperator.class) ShopHotWordRequest request) {
       return shopHotWordApi.update(request);
   }

    @RequiresPermissions("shopHotWord")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopHotWordRequest request) {
        return shopHotWordApi.delete(request);
    }

    @RequiresPermissions("shopHotWord")
    @RequestMapping("/view")
    public ResponseObject <ShopHotWordResponse> view(@Validated(ViewOperator.class) ShopHotWordRequest  request) {
        return shopHotWordApi.view(request);
    }
}