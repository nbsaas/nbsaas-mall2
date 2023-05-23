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
import com.nbsaas.life.system.api.domain.request.RecordLogDataRequest;
import com.nbsaas.life.system.api.domain.request.RecordLogSearchRequest;
import com.nbsaas.life.system.api.domain.response.RecordLogResponse;
import com.nbsaas.life.system.api.domain.simple.RecordLogSimple;
import com.nbsaas.life.system.api.apis.RecordLogApi;
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
@RequestMapping("/recordLog")
public class RecordLogFrontController {


    @Resource
    private RecordLogApi recordLogApi;


    @RequestMapping("/search")
   public PageResponse<RecordLogSimple> search(RecordLogSearchRequest request) {
        return recordLogApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <RecordLogSimple> list(RecordLogSearchRequest request) {
        return recordLogApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<RecordLogResponse> create(@Validated(AddOperator.class) RecordLogDataRequest request) {
       return recordLogApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <RecordLogResponse> update(@Validated(UpdateOperator.class) RecordLogDataRequest request) {
         return recordLogApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) RecordLogDataRequest request) {
        return recordLogApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <RecordLogResponse> view(@Validated(ViewOperator.class) RecordLogDataRequest request) {
         return recordLogApi.view(request);
    }
}
