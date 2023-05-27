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
import com.nbsaas.life.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.life.user.api.domain.request.UserLoginLogSearchRequest;
import com.nbsaas.life.user.api.domain.response.UserLoginLogResponse;
import com.nbsaas.life.user.api.domain.simple.UserLoginLogSimple;
import com.nbsaas.life.user.api.apis.UserLoginLogApi;
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
@RequestMapping("/userLoginLog")
public class UserLoginLogController {


      @Resource
      private UserLoginLogApi userLoginLogApi;


    @RequestMapping("/search")
    public PageResponse<UserLoginLogSimple> search(UserLoginLogSearchRequest request) {
         return userLoginLogApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<UserLoginLogSimple> list(UserLoginLogSearchRequest request) {
        return userLoginLogApi.list(request);
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
        <UserLoginLogResponse> create(@Validated(AddOperator.class) UserLoginLogDataRequest request) {
            return userLoginLogApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<UserLoginLogResponse> update(@Validated(UpdateOperator.class) UserLoginLogDataRequest request) {
          return userLoginLogApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserLoginLogDataRequest request) {
         return userLoginLogApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <UserLoginLogResponse> view(@Validated(ViewOperator.class) UserLoginLogDataRequest request) {
          return userLoginLogApi.view(request);
       }
}