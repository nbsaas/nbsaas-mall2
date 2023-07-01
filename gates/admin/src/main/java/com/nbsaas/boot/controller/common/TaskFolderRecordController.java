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
import com.nbsaas.boot.common.api.domain.request.TaskFolderRecordDataRequest;
import com.nbsaas.boot.common.api.domain.request.TaskFolderRecordSearchRequest;
import com.nbsaas.boot.common.api.domain.response.TaskFolderRecordResponse;
import com.nbsaas.boot.common.api.domain.simple.TaskFolderRecordSimple;
import com.nbsaas.boot.common.api.apis.TaskFolderRecordApi;
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
@RequestMapping("/taskFolderRecord")
public class TaskFolderRecordController {


    @Resource
    private TaskFolderRecordApi taskFolderRecordApi;


    @RequestMapping("/search")
    public PageResponse <TaskFolderRecordSimple> search(TaskFolderRecordSearchRequest request) {
        return taskFolderRecordApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<TaskFolderRecordSimple> list(TaskFolderRecordSearchRequest request) {
        return taskFolderRecordApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TaskFolderRecordResponse> create(@Validated(AddOperator.class) TaskFolderRecordDataRequest request) {
        return taskFolderRecordApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TaskFolderRecordResponse> update(@Validated(UpdateOperator.class) TaskFolderRecordDataRequest request) {
       return taskFolderRecordApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TaskFolderRecordDataRequest request) {
        return taskFolderRecordApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <TaskFolderRecordResponse> view(@Validated(ViewOperator.class) TaskFolderRecordDataRequest  request) {
        return taskFolderRecordApi.view(request);
    }
}