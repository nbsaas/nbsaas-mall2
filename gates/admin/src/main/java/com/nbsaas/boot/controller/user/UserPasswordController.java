package com.nbsaas.boot.controller.user;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.apis.UserPasswordApi;
import com.nbsaas.boot.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserPasswordSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.boot.user.api.domain.simple.UserPasswordSimple;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/userPassword")
public class UserPasswordController {


      @Resource
      private UserPasswordApi userPasswordApi;


    @RequestMapping("/search")
    public PageResponse<UserPasswordSimple> search(UserPasswordSearchRequest request) {
         return userPasswordApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<UserPasswordSimple> list(UserPasswordSearchRequest request) {
        return userPasswordApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
        @CreateData
        @RequestMapping("/create")
        public ResponseObject
        <UserPasswordResponse> create(@Validated(AddOperator.class) UserPasswordDataRequest request) {
            return userPasswordApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<UserPasswordResponse> update(@Validated(UpdateOperator.class) UserPasswordDataRequest request) {
          return userPasswordApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserPasswordDataRequest request) {
         return userPasswordApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <UserPasswordResponse> view(@Validated(ViewOperator.class) UserPasswordDataRequest request) {
          return userPasswordApi.view(request);
       }
}