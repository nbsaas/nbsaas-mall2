package com.nbsaas.life.controller.area;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.life.area.api.domain.request.AreaHotDataRequest;
import com.nbsaas.life.area.api.domain.request.AreaHotSearchRequest;
import com.nbsaas.life.area.api.domain.response.AreaHotResponse;
import com.nbsaas.life.area.api.domain.simple.AreaHotSimple;
import com.nbsaas.life.area.api.apis.AreaHotApi;
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
@RequestMapping("/areaHot")
public class AreaHotController {


      @Resource
      private AreaHotApi areaHotApi;


    @RequestMapping("/search")
    public PageResponse<AreaHotSimple> search(AreaHotSearchRequest request) {
         return areaHotApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<AreaHotSimple> list(AreaHotSearchRequest request) {
        return areaHotApi.list(request);
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
        <AreaHotResponse> create(@Validated(AddOperator.class) AreaHotDataRequest request) {
            return areaHotApi.create(request);
        }

        @UpdateData
       @RequestMapping("/update")
       public ResponseObject<AreaHotResponse> update(@Validated(UpdateOperator.class) AreaHotDataRequest request) {
          return areaHotApi.update(request);
       }

      @RequestMapping("/delete")
      public ResponseObject<?> delete(@Validated(DeleteOperator.class) AreaHotDataRequest request) {
         return areaHotApi.delete(request);
      }

       @RequestMapping("/view")
       public ResponseObject <AreaHotResponse> view(@Validated(ViewOperator.class) AreaHotDataRequest request) {
          return areaHotApi.view(request);
       }
}