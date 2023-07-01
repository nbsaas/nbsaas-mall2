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
import com.nbsaas.life.shop.api.domain.request.ShopImageDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopImageSearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopImageResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopImageSimple;
import com.nbsaas.life.shop.api.apis.ShopImageApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/shopImage")
public class ShopImageController {


    @Resource
    private ShopImageApi shopImageApi;


    @RequestMapping("/search")
    public PageResponse <ShopImageSimple> search(ShopImageSearchRequest request) {
        return shopImageApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopImageSimple> list(ShopImageSearchRequest request) {
        return shopImageApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopImageResponse> create(@Validated(AddOperator.class) ShopImageDataRequest request) {
        return shopImageApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopImageResponse> update(@Validated(UpdateOperator.class) ShopImageDataRequest request) {
       return shopImageApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopImageDataRequest request) {
        return shopImageApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <ShopImageResponse> view(@Validated(ViewOperator.class) ShopImageDataRequest  request) {
        return shopImageApi.view(request);
    }
}