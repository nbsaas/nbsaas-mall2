package com.nbsaas.boot.controller.ad;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.ad.api.domain.request.GroupMessageDataRequest;
import com.nbsaas.boot.ad.api.domain.request.GroupMessageSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.GroupMessageResponse;
import com.nbsaas.boot.ad.api.domain.simple.GroupMessageSimple;
import com.nbsaas.boot.ad.api.apis.GroupMessageApi;
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
@RequestMapping("/groupMessage")
public class GroupMessageController {


    @Resource
    private GroupMessageApi groupMessageApi;


    @RequestMapping("/search")
    public PageResponse <GroupMessageSimple> search(GroupMessageSearchRequest request) {
        return groupMessageApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<GroupMessageSimple> list(GroupMessageSearchRequest request) {
        return groupMessageApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <GroupMessageResponse> create(@Validated(AddOperator.class) GroupMessageDataRequest request) {
        return groupMessageApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<GroupMessageResponse> update(@Validated(UpdateOperator.class) GroupMessageDataRequest request) {
       return groupMessageApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) GroupMessageDataRequest request) {
        return groupMessageApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <GroupMessageResponse> view(@Validated(ViewOperator.class) GroupMessageDataRequest  request) {
        return groupMessageApi.view(request);
    }
}