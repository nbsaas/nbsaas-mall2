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
import com.nbsaas.life.shop.api.domain.request.ShopStaffRoleRequest;
import com.nbsaas.life.shop.api.domain.request.ShopStaffRoleSearch;
import com.nbsaas.life.shop.api.domain.response.ShopStaffRoleResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopStaffRoleSimple;
import com.nbsaas.life.shop.api.apis.ShopStaffRoleApi;
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
@RequestMapping("/shopStaffRole")
public class ShopStaffRoleFrontController {


    @Resource
    private ShopStaffRoleApi shopStaffRoleApi;


    @RequestMapping("/search")
    public PageResponse<ShopStaffRoleSimple> search(ShopStaffRoleSearch request) {
        return shopStaffRoleApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ShopStaffRoleSimple> list(ShopStaffRoleSearch request) {
        return shopStaffRoleApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ShopStaffRoleResponse> create(@Validated(AddOperator.class) ShopStaffRoleRequest request) {
        return shopStaffRoleApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <ShopStaffRoleResponse> update(@Validated(UpdateOperator.class) ShopStaffRoleRequest request) {
        return shopStaffRoleApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopStaffRoleRequest request) {
     return shopStaffRoleApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ShopStaffRoleResponse> view(@Validated(ViewOperator.class) ShopStaffRoleRequest request) {
        return shopStaffRoleApi.view(request);
    }
}