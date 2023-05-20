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
import com.nbsaas.life.shop.api.domain.request.ShopTagDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopTagSearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopTagResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopTagSimple;
import com.nbsaas.life.shop.api.apis.ShopTagApi;
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
@RequestMapping("/shopTag")
public class ShopTagController {


      @Resource
      private ShopTagApi shopTagApi;


    @RequestMapping("/search")
    public PageResponse<ShopTagSimple> search(ShopTagSearchRequest request) {
         return shopTagApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopTagSimple> list(ShopTagSearchRequest request) {
        return shopTagApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
        @CreateData
        @RequestMapping("/create")
        public ResponseObject
        <ShopTagResponse> create(@Validated(AddOperator.class) ShopTagDataRequest request) {
            return shopTagApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<ShopTagResponse> update(@Validated(UpdateOperator.class) ShopTagDataRequest request) {
          return shopTagApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopTagDataRequest request) {
         return shopTagApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <ShopTagResponse> view(@Validated(ViewOperator.class) ShopTagDataRequest request) {
          return shopTagApi.view(request);
       }
}