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
import com.nbsaas.boot.common.api.domain.request.TaskFolderItemDataRequest;
import com.nbsaas.boot.common.api.domain.request.TaskFolderItemSearchRequest;
import com.nbsaas.boot.common.api.domain.response.TaskFolderItemResponse;
import com.nbsaas.boot.common.api.domain.simple.TaskFolderItemSimple;
import com.nbsaas.boot.common.api.apis.TaskFolderItemApi;
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
@RequestMapping("/taskFolderItem")
public class TaskFolderItemController {


    @Resource
    private TaskFolderItemApi taskFolderItemApi;


    @RequestMapping("/search")
    public PageResponse <TaskFolderItemSimple> search(TaskFolderItemSearchRequest request) {
        return taskFolderItemApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<TaskFolderItemSimple> list(TaskFolderItemSearchRequest request) {
        return taskFolderItemApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TaskFolderItemResponse> create(@Validated(AddOperator.class) TaskFolderItemDataRequest request) {
        return taskFolderItemApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TaskFolderItemResponse> update(@Validated(UpdateOperator.class) TaskFolderItemDataRequest request) {
       return taskFolderItemApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TaskFolderItemDataRequest request) {
        return taskFolderItemApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <TaskFolderItemResponse> view(@Validated(ViewOperator.class) TaskFolderItemDataRequest  request) {
        return taskFolderItemApi.view(request);
    }
}