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
import com.nbsaas.life.shop.api.domain.request.ShopCategoryDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopCategorySearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopCategoryResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopCategorySimple;
import com.nbsaas.life.shop.api.apis.ShopCategoryApi;
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
@RequestMapping("/shopCategory")
public class ShopCategoryController {


      @Resource
      private ShopCategoryApi shopCategoryApi;


    @RequestMapping("/search")
    public PageResponse<ShopCategorySimple> search(ShopCategorySearchRequest request) {
         return shopCategoryApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopCategorySimple> list(ShopCategorySearchRequest request) {
        return shopCategoryApi.list(request);
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
        <ShopCategoryResponse> create(@Validated(AddOperator.class) ShopCategoryDataRequest request) {
            return shopCategoryApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<ShopCategoryResponse> update(@Validated(UpdateOperator.class) ShopCategoryDataRequest request) {
          return shopCategoryApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopCategoryDataRequest request) {
         return shopCategoryApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <ShopCategoryResponse> view(@Validated(ViewOperator.class) ShopCategoryDataRequest request) {
          return shopCategoryApi.view(request);
       }
}