package com.nbsaas.boot.controller.common;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.common.api.domain.request.SequenceTableRequest;
import com.nbsaas.boot.common.api.domain.request.SequenceTableSearch;
import com.nbsaas.boot.common.api.domain.response.SequenceTableResponse;
import com.nbsaas.boot.common.api.domain.simple.SequenceTableSimple;
import com.nbsaas.boot.common.api.apis.SequenceTableApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/sequenceTable")
public class SequenceTableController {


    @Resource
    private SequenceTableApi sequenceTableApi;


    @RequiresPermissions("sequenceTable")
    @RequestMapping("/search")
    public PageResponse <SequenceTableSimple> search(SequenceTableSearch request) {
        return sequenceTableApi.search(request);
    }

    @RequiresPermissions("sequenceTable")
    @RequestMapping("/list")
    public ListResponse<SequenceTableSimple> list(SequenceTableSearch request) {
        return sequenceTableApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("sequenceTable")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <SequenceTableResponse> create(@Validated(AddOperator.class) SequenceTableRequest request) {
        return sequenceTableApi.create(request);
    }

   @RequiresPermissions("sequenceTable")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<SequenceTableResponse> update(@Validated(UpdateOperator.class) SequenceTableRequest request) {
       return sequenceTableApi.update(request);
   }

    @RequiresPermissions("sequenceTable")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) SequenceTableRequest request) {
        return sequenceTableApi.delete(request);
    }

    @RequiresPermissions("sequenceTable")
    @RequestMapping("/view")
    public ResponseObject <SequenceTableResponse> view(@Validated(ViewOperator.class) SequenceTableRequest  request) {
        return sequenceTableApi.view(request);
    }
}