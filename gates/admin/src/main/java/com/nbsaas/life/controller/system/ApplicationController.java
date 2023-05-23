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
import com.nbsaas.life.system.api.domain.request.ApplicationDataRequest;
import com.nbsaas.life.system.api.domain.request.ApplicationSearchRequest;
import com.nbsaas.life.system.api.domain.response.ApplicationResponse;
import com.nbsaas.life.system.api.domain.simple.ApplicationSimple;
import com.nbsaas.life.system.api.apis.ApplicationApi;
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
@RequestMapping("/application")
public class ApplicationController {


      @Resource
      private ApplicationApi applicationApi;


    @RequestMapping("/search")
    public PageResponse<ApplicationSimple> search(ApplicationSearchRequest request) {
         return applicationApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ApplicationSimple> list(ApplicationSearchRequest request) {
        return applicationApi.list(request);
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
        <ApplicationResponse> create(@Validated(AddOperator.class) ApplicationDataRequest request) {
            return applicationApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<ApplicationResponse> update(@Validated(UpdateOperator.class) ApplicationDataRequest request) {
          return applicationApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) ApplicationDataRequest request) {
         return applicationApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <ApplicationResponse> view(@Validated(ViewOperator.class) ApplicationDataRequest request) {
          return applicationApi.view(request);
       }
}