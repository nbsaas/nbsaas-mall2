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
import com.nbsaas.boot.shop.api.domain.request.ShopTagRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopTagSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopTagResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopTagSimple;
import com.nbsaas.boot.shop.api.apis.ShopTagApi;
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
@RequestMapping("/shopTag")
public class ShopTagController {


    @Resource
    private ShopTagApi shopTagApi;


    @RequiresPermissions("shopTag")
    @RequestMapping("/search")
    public PageResponse <ShopTagSimple> search(ShopTagSearch request) {
        return shopTagApi.search(request);
    }

    @RequiresPermissions("shopTag")
    @RequestMapping("/list")
    public ListResponse<ShopTagSimple> list(ShopTagSearch request) {
        return shopTagApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopTag")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopTagResponse> create(@Validated(AddOperator.class) ShopTagRequest request) {
        return shopTagApi.create(request);
    }

   @RequiresPermissions("shopTag")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopTagResponse> update(@Validated(UpdateOperator.class) ShopTagRequest request) {
       return shopTagApi.update(request);
   }

    @RequiresPermissions("shopTag")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopTagRequest request) {
        return shopTagApi.delete(request);
    }

    @RequiresPermissions("shopTag")
    @RequestMapping("/view")
    public ResponseObject <ShopTagResponse> view(@Validated(ViewOperator.class) ShopTagRequest  request) {
        return shopTagApi.view(request);
    }
}