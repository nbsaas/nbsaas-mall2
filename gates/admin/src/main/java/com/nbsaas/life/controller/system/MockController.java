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
import com.nbsaas.life.system.api.domain.request.MockDataRequest;
import com.nbsaas.life.system.api.domain.request.MockSearchRequest;
import com.nbsaas.life.system.api.domain.response.MockResponse;
import com.nbsaas.life.system.api.domain.simple.MockSimple;
import com.nbsaas.life.system.api.apis.MockApi;
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
@RequestMapping("/mock")
public class MockController {


      @Resource
      private MockApi mockApi;


    @RequestMapping("/search")
    public PageResponse<MockSimple> search(MockSearchRequest request) {
         return mockApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<MockSimple> list(MockSearchRequest request) {
        return mockApi.list(request);
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
        <MockResponse> create(@Validated(AddOperator.class) MockDataRequest request) {
            return mockApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<MockResponse> update(@Validated(UpdateOperator.class) MockDataRequest request) {
          return mockApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) MockDataRequest request) {
         return mockApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <MockResponse> view(@Validated(ViewOperator.class) MockDataRequest request) {
          return mockApi.view(request);
       }
}