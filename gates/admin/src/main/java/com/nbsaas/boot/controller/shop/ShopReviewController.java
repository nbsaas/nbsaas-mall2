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
import com.nbsaas.boot.shop.api.domain.request.ShopReviewRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopReviewSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopReviewResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopReviewSimple;
import com.nbsaas.boot.shop.api.apis.ShopReviewApi;
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
@RequestMapping("/shopReview")
public class ShopReviewController {


    @Resource
    private ShopReviewApi shopReviewApi;


    @RequiresPermissions("shopReview")
    @RequestMapping("/search")
    public PageResponse <ShopReviewSimple> search(ShopReviewSearch request) {
        return shopReviewApi.search(request);
    }

    @RequiresPermissions("shopReview")
    @RequestMapping("/list")
    public ListResponse<ShopReviewSimple> list(ShopReviewSearch request) {
        return shopReviewApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopReview")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopReviewResponse> create(@Validated(AddOperator.class) ShopReviewRequest request) {
        return shopReviewApi.create(request);
    }

   @RequiresPermissions("shopReview")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopReviewResponse> update(@Validated(UpdateOperator.class) ShopReviewRequest request) {
       return shopReviewApi.update(request);
   }

    @RequiresPermissions("shopReview")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopReviewRequest request) {
        return shopReviewApi.delete(request);
    }

    @RequiresPermissions("shopReview")
    @RequestMapping("/view")
    public ResponseObject <ShopReviewResponse> view(@Validated(ViewOperator.class) ShopReviewRequest  request) {
        return shopReviewApi.view(request);
    }
}