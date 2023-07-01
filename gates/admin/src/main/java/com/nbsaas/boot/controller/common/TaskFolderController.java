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
import com.nbsaas.boot.common.api.domain.request.TaskFolderDataRequest;
import com.nbsaas.boot.common.api.domain.request.TaskFolderSearchRequest;
import com.nbsaas.boot.common.api.domain.response.TaskFolderResponse;
import com.nbsaas.boot.common.api.domain.simple.TaskFolderSimple;
import com.nbsaas.boot.common.api.apis.TaskFolderApi;
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
@RequestMapping("/taskFolder")
public class TaskFolderController {


    @Resource
    private TaskFolderApi taskFolderApi;


    @RequestMapping("/search")
    public PageResponse <TaskFolderSimple> search(TaskFolderSearchRequest request) {
        return taskFolderApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<TaskFolderSimple> list(TaskFolderSearchRequest request) {
        return taskFolderApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TaskFolderResponse> create(@Validated(AddOperator.class) TaskFolderDataRequest request) {
        return taskFolderApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TaskFolderResponse> update(@Validated(UpdateOperator.class) TaskFolderDataRequest request) {
       return taskFolderApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TaskFolderDataRequest request) {
        return taskFolderApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <TaskFolderResponse> view(@Validated(ViewOperator.class) TaskFolderDataRequest  request) {
        return taskFolderApi.view(request);
    }
}