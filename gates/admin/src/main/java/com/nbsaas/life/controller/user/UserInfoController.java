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
import com.nbsaas.life.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.life.user.api.domain.request.UserInfoSearchRequest;
import com.nbsaas.life.user.api.domain.response.UserInfoResponse;
import com.nbsaas.life.user.api.domain.simple.UserInfoSimple;
import com.nbsaas.life.user.api.apis.UserInfoApi;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {


      @Resource
      private UserInfoApi userInfoApi;


    @RequestMapping("/search")
    public PageResponse<UserInfoSimple> search(UserInfoSearchRequest request) {
         return userInfoApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<UserInfoSimple> list(UserInfoSearchRequest request) {
        return userInfoApi.list(request);
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
        <UserInfoResponse> create(@Validated(AddOperator.class) UserInfoDataRequest request) {
            return userInfoApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<UserInfoResponse> update(@Validated(UpdateOperator.class) UserInfoDataRequest request) {
          return userInfoApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserInfoDataRequest request) {
         return userInfoApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <UserInfoResponse> view(@Validated(ViewOperator.class) UserInfoDataRequest request) {
          return userInfoApi.view(request);
       }
}