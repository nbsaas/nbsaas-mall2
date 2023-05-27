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
import com.nbsaas.life.user.api.domain.request.UserAccountDataRequest;
import com.nbsaas.life.user.api.domain.request.UserAccountSearchRequest;
import com.nbsaas.life.user.api.domain.response.UserAccountResponse;
import com.nbsaas.life.user.api.domain.simple.UserAccountSimple;
import com.nbsaas.life.user.api.apis.UserAccountApi;
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
@RequestMapping("/userAccount")
public class UserAccountFrontController {


    @Resource
    private UserAccountApi userAccountApi;


    @RequestMapping("/search")
   public PageResponse<UserAccountSimple> search(UserAccountSearchRequest request) {
        return userAccountApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <UserAccountSimple> list(UserAccountSearchRequest request) {
        return userAccountApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<UserAccountResponse> create(@Validated(AddOperator.class) UserAccountDataRequest request) {
       return userAccountApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <UserAccountResponse> update(@Validated(UpdateOperator.class) UserAccountDataRequest request) {
         return userAccountApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserAccountDataRequest request) {
        return userAccountApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <UserAccountResponse> view(@Validated(ViewOperator.class) UserAccountDataRequest request) {
         return userAccountApi.view(request);
    }
}
