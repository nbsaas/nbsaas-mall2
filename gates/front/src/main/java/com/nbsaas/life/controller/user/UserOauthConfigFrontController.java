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
import com.nbsaas.life.user.api.domain.request.UserOauthConfigDataRequest;
import com.nbsaas.life.user.api.domain.request.UserOauthConfigSearchRequest;
import com.nbsaas.life.user.api.domain.response.UserOauthConfigResponse;
import com.nbsaas.life.user.api.domain.simple.UserOauthConfigSimple;
import com.nbsaas.life.user.api.apis.UserOauthConfigApi;
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
@RequestMapping("/userOauthConfig")
public class UserOauthConfigFrontController {


    @Resource
    private UserOauthConfigApi userOauthConfigApi;


    @RequestMapping("/search")
   public PageResponse<UserOauthConfigSimple> search(UserOauthConfigSearchRequest request) {
        return userOauthConfigApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <UserOauthConfigSimple> list(UserOauthConfigSearchRequest request) {
        return userOauthConfigApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<UserOauthConfigResponse> create(@Validated(AddOperator.class) UserOauthConfigDataRequest request) {
       return userOauthConfigApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <UserOauthConfigResponse> update(@Validated(UpdateOperator.class) UserOauthConfigDataRequest request) {
         return userOauthConfigApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserOauthConfigDataRequest request) {
        return userOauthConfigApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <UserOauthConfigResponse> view(@Validated(ViewOperator.class) UserOauthConfigDataRequest request) {
         return userOauthConfigApi.view(request);
    }
}
