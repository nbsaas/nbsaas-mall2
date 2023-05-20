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
import com.nbsaas.life.shop.api.domain.request.ShopDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopSearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopSimple;
import com.nbsaas.life.shop.api.apis.ShopApi;
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
@RequestMapping("/shop")
public class ShopFrontController {


    @Resource
    private ShopApi shopApi;


    @RequestMapping("/search")
   public PageResponse<ShopSimple> search(ShopSearchRequest request) {
        return shopApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <ShopSimple> list(ShopSearchRequest request) {
        return shopApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<ShopResponse> create(@Validated(AddOperator.class) ShopDataRequest request) {
       return shopApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <ShopResponse> update(@Validated(UpdateOperator.class) ShopDataRequest request) {
         return shopApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopDataRequest request) {
        return shopApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <ShopResponse> view(@Validated(ViewOperator.class) ShopDataRequest request) {
         return shopApi.view(request);
    }
}
