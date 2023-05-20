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
import com.nbsaas.life.user.api.domain.request.UserCityDataRequest;
import com.nbsaas.life.user.api.domain.request.UserCitySearchRequest;
import com.nbsaas.life.user.api.domain.response.UserCityResponse;
import com.nbsaas.life.user.api.domain.simple.UserCitySimple;
import com.nbsaas.life.user.api.apis.UserCityApi;
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
@RequestMapping("/userCity")
public class UserCityFrontController {


    @Resource
    private UserCityApi userCityApi;


    @RequestMapping("/search")
   public PageResponse<UserCitySimple> search(UserCitySearchRequest request) {
        return userCityApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <UserCitySimple> list(UserCitySearchRequest request) {
        return userCityApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<UserCityResponse> create(@Validated(AddOperator.class) UserCityDataRequest request) {
       return userCityApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <UserCityResponse> update(@Validated(UpdateOperator.class) UserCityDataRequest request) {
         return userCityApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserCityDataRequest request) {
        return userCityApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <UserCityResponse> view(@Validated(ViewOperator.class) UserCityDataRequest request) {
         return userCityApi.view(request);
    }
}
