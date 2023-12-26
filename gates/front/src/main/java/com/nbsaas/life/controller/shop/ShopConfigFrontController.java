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
import com.nbsaas.life.shop.api.domain.request.ShopConfigRequest;
import com.nbsaas.life.shop.api.domain.request.ShopConfigSearch;
import com.nbsaas.life.shop.api.domain.response.ShopConfigResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopConfigSimple;
import com.nbsaas.life.shop.api.apis.ShopConfigApi;
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
@RequestMapping("/shopConfig")
public class ShopConfigFrontController {


    @Resource
    private ShopConfigApi shopConfigApi;


    @RequestMapping("/search")
    public PageResponse<ShopConfigSimple> search(ShopConfigSearch request) {
        return shopConfigApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopConfigSimple> list(ShopConfigSearch request) {
        return shopConfigApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ShopConfigResponse> create(@Validated(AddOperator.class) ShopConfigRequest request) {
        return shopConfigApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ShopConfigResponse> update(@Validated(UpdateOperator.class) ShopConfigRequest request) {
        return shopConfigApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopConfigRequest request) {
     return shopConfigApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ShopConfigResponse> view(@Validated(ViewOperator.class) ShopConfigRequest request) {
        return shopConfigApi.view(request);
    }
}