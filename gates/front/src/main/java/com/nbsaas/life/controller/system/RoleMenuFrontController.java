package com.nbsaas.life.controller.system;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.life.system.api.domain.request.RoleMenuDataRequest;
import com.nbsaas.life.system.api.domain.request.RoleMenuSearchRequest;
import com.nbsaas.life.system.api.domain.response.RoleMenuResponse;
import com.nbsaas.life.system.api.domain.simple.RoleMenuSimple;
import com.nbsaas.life.system.api.apis.RoleMenuApi;
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
@RequestMapping("/roleMenu")
public class RoleMenuFrontController {


    @Resource
    private RoleMenuApi roleMenuApi;


    @RequestMapping("/search")
   public PageResponse<RoleMenuSimple> search(RoleMenuSearchRequest request) {
        return roleMenuApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <RoleMenuSimple> list(RoleMenuSearchRequest request) {
        return roleMenuApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<RoleMenuResponse> create(@Validated(AddOperator.class) RoleMenuDataRequest request) {
       return roleMenuApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <RoleMenuResponse> update(@Validated(UpdateOperator.class) RoleMenuDataRequest request) {
         return roleMenuApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) RoleMenuDataRequest request) {
        return roleMenuApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <RoleMenuResponse> view(@Validated(ViewOperator.class) RoleMenuDataRequest request) {
         return roleMenuApi.view(request);
    }
}
