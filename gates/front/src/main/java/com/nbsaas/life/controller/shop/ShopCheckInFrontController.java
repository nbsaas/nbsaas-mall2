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
import com.nbsaas.life.shop.api.domain.request.ShopCheckInDataRequest;
import com.nbsaas.life.shop.api.domain.request.ShopCheckInSearchRequest;
import com.nbsaas.life.shop.api.domain.response.ShopCheckInResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopCheckInSimple;
import com.nbsaas.life.shop.api.apis.ShopCheckInApi;
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
@RequestMapping("/shopCheckIn")
public class ShopCheckInFrontController {


    @Resource
    private ShopCheckInApi shopCheckInApi;


    @RequestMapping("/search")
    public PageResponse<ShopCheckInSimple> search(ShopCheckInSearchRequest request) {
        return shopCheckInApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopCheckInSimple> list(ShopCheckInSearchRequest request) {
        return shopCheckInApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ShopCheckInResponse> create(@Validated(AddOperator.class) ShopCheckInDataRequest request) {
        return shopCheckInApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ShopCheckInResponse> update(@Validated(UpdateOperator.class) ShopCheckInDataRequest request) {
        return shopCheckInApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopCheckInDataRequest request) {
     return shopCheckInApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ShopCheckInResponse> view(@Validated(ViewOperator.class) ShopCheckInDataRequest request) {
        return shopCheckInApi.view(request);
    }
}