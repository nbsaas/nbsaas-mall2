package com.nbsaas.life.controller.user;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.life.user.api.domain.request.UserRoleDataRequest;
import com.nbsaas.life.user.api.domain.request.UserRoleSearchRequest;
import com.nbsaas.life.user.api.domain.response.UserRoleResponse;
import com.nbsaas.life.user.api.domain.simple.UserRoleSimple;
import com.nbsaas.life.user.api.apis.UserRoleApi;
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
@RequestMapping("/userRole")
public class UserRoleFrontController {


    @Resource
    private UserRoleApi userRoleApi;


    @RequestMapping("/search")
   public PageResponse<UserRoleSimple> search(UserRoleSearchRequest request) {
        return userRoleApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <UserRoleSimple> list(UserRoleSearchRequest request) {
        return userRoleApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<UserRoleResponse> create(@Validated(AddOperator.class) UserRoleDataRequest request) {
       return userRoleApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <UserRoleResponse> update(@Validated(UpdateOperator.class) UserRoleDataRequest request) {
         return userRoleApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserRoleDataRequest request) {
        return userRoleApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <UserRoleResponse> view(@Validated(ViewOperator.class) UserRoleDataRequest request) {
         return userRoleApi.view(request);
    }
}
