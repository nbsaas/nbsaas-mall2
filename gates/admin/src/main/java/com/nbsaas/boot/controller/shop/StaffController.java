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
import com.nbsaas.boot.shop.api.domain.request.StaffRequest;
import com.nbsaas.boot.shop.api.domain.request.StaffSearch;
import com.nbsaas.boot.shop.api.domain.response.StaffResponse;
import com.nbsaas.boot.shop.api.domain.simple.StaffSimple;
import com.nbsaas.boot.shop.api.apis.StaffApi;
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
@RequestMapping("/staff")
public class StaffController {


    @Resource
    private StaffApi staffApi;


    @RequiresPermissions("staff")
    @RequestMapping("/search")
    public PageResponse <StaffSimple> search(StaffSearch request) {
        return staffApi.search(request);
    }

    @RequiresPermissions("staff")
    @RequestMapping("/list")
    public ListResponse<StaffSimple> list(StaffSearch request) {
        return staffApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("staff")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <StaffResponse> create(@Validated(AddOperator.class) StaffRequest request) {
        return staffApi.create(request);
    }

   @RequiresPermissions("staff")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<StaffResponse> update(@Validated(UpdateOperator.class) StaffRequest request) {
       return staffApi.update(request);
   }

    @RequiresPermissions("staff")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) StaffRequest request) {
        return staffApi.delete(request);
    }

    @RequiresPermissions("staff")
    @RequestMapping("/view")
    public ResponseObject <StaffResponse> view(@Validated(ViewOperator.class) StaffRequest  request) {
        return staffApi.view(request);
    }
}