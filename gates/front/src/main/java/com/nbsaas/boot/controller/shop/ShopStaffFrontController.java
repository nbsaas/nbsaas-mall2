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
import com.nbsaas.boot.shop.api.domain.request.ShopStaffRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopStaffSimple;
import com.nbsaas.boot.shop.api.apis.ShopStaffApi;
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
@RequestMapping("/shopStaff")
public class ShopStaffFrontController {


    @Resource
    private ShopStaffApi shopStaffApi;


    @RequestMapping("/search")
    public PageResponse<ShopStaffSimple> search(ShopStaffSearch request) {
        return shopStaffApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopStaffSimple> list(ShopStaffSearch request) {
        return shopStaffApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ShopStaffResponse> create(@Validated(AddOperator.class) ShopStaffRequest request) {
        return shopStaffApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ShopStaffResponse> update(@Validated(UpdateOperator.class) ShopStaffRequest request) {
        return shopStaffApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopStaffRequest request) {
     return shopStaffApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ShopStaffResponse> view(@Validated(ViewOperator.class) ShopStaffRequest request) {
        return shopStaffApi.view(request);
    }
}