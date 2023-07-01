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
import com.nbsaas.life.shop.api.domain.request.ShopReviewDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopReviewSearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopReviewResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopReviewSimple;
import com.nbsaas.life.shop.api.apis.ShopReviewApi;
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
@RequestMapping("/shopReview")
public class ShopReviewFrontController {


    @Resource
    private ShopReviewApi shopReviewApi;


    @RequestMapping("/search")
    public PageResponse<ShopReviewSimple> search(ShopReviewSearchRequest request) {
        return shopReviewApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopReviewSimple> list(ShopReviewSearchRequest request) {
        return shopReviewApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ShopReviewResponse> create(@Validated(AddOperator.class) ShopReviewDataRequest request) {
        return shopReviewApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ShopReviewResponse> update(@Validated(UpdateOperator.class) ShopReviewDataRequest request) {
        return shopReviewApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopReviewDataRequest request) {
     return shopReviewApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ShopReviewResponse> view(@Validated(ViewOperator.class) ShopReviewDataRequest request) {
        return shopReviewApi.view(request);
    }
}