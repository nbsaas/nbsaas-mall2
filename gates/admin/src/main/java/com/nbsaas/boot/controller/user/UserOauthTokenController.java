package com.nbsaas.boot.controller.user;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.apis.UserOauthTokenApi;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserOauthTokenResponse;
import com.nbsaas.boot.user.api.domain.simple.UserOauthTokenSimple;
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
@RequestMapping("/userOauthToken")
public class UserOauthTokenController {


      @Resource
      private UserOauthTokenApi userOauthTokenApi;


    @RequestMapping("/search")
    public PageResponse<UserOauthTokenSimple> search(UserOauthTokenSearchRequest request) {
         return userOauthTokenApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<UserOauthTokenSimple> list(UserOauthTokenSearchRequest request) {
        return userOauthTokenApi.list(request);
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
        <UserOauthTokenResponse> create(@Validated(AddOperator.class) UserOauthTokenDataRequest request) {
            return userOauthTokenApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<UserOauthTokenResponse> update(@Validated(UpdateOperator.class) UserOauthTokenDataRequest request) {
          return userOauthTokenApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserOauthTokenDataRequest request) {
         return userOauthTokenApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <UserOauthTokenResponse> view(@Validated(ViewOperator.class) UserOauthTokenDataRequest request) {
          return userOauthTokenApi.view(request);
       }
}