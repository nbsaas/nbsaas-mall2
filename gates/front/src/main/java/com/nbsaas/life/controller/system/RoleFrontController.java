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
import com.nbsaas.life.system.api.domain.request.RoleDataRequest;
import com.nbsaas.life.system.api.domain.request.RoleSearchRequest;
import com.nbsaas.life.system.api.domain.response.RoleResponse;
import com.nbsaas.life.system.api.domain.simple.RoleSimple;
import com.nbsaas.life.system.api.apis.RoleApi;
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
@RequestMapping("/role")
public class RoleFrontController {


    @Resource
    private RoleApi roleApi;


    @RequestMapping("/search")
   public PageResponse<RoleSimple> search(RoleSearchRequest request) {
        return roleApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <RoleSimple> list(RoleSearchRequest request) {
        return roleApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<RoleResponse> create(@Validated(AddOperator.class) RoleDataRequest request) {
       return roleApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <RoleResponse> update(@Validated(UpdateOperator.class) RoleDataRequest request) {
         return roleApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) RoleDataRequest request) {
        return roleApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <RoleResponse> view(@Validated(ViewOperator.class) RoleDataRequest request) {
         return roleApi.view(request);
    }
}
