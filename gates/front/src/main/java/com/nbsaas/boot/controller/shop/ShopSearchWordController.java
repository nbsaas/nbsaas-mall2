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
import com.nbsaas.boot.shop.api.domain.request.ShopSearchWordRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopSearchWordSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopSearchWordResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopSearchWordSimple;
import com.nbsaas.boot.shop.api.apis.ShopSearchWordApi;
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
@RequestMapping("/shopSearchWord")
public class ShopSearchWordController {


    @Resource
    private ShopSearchWordApi shopSearchWordApi;


    @RequiresPermissions("shopSearchWord")
    @RequestMapping("/search")
    public PageResponse <ShopSearchWordSimple> search(ShopSearchWordSearch request) {
        return shopSearchWordApi.search(request);
    }

    @RequiresPermissions("shopSearchWord")
    @RequestMapping("/list")
    public ListResponse<ShopSearchWordSimple> list(ShopSearchWordSearch request) {
        return shopSearchWordApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopSearchWord")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopSearchWordResponse> create(@Validated(AddOperator.class) ShopSearchWordRequest request) {
        return shopSearchWordApi.create(request);
    }

   @RequiresPermissions("shopSearchWord")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopSearchWordResponse> update(@Validated(UpdateOperator.class) ShopSearchWordRequest request) {
       return shopSearchWordApi.update(request);
   }

    @RequiresPermissions("shopSearchWord")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopSearchWordRequest request) {
        return shopSearchWordApi.delete(request);
    }

    @RequiresPermissions("shopSearchWord")
    @RequestMapping("/view")
    public ResponseObject <ShopSearchWordResponse> view(@Validated(ViewOperator.class) ShopSearchWordRequest  request) {
        return shopSearchWordApi.view(request);
    }
}