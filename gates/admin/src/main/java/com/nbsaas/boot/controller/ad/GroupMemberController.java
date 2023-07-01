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
import com.nbsaas.boot.ad.api.domain.request.GroupMemberDataRequest;
import com.nbsaas.boot.ad.api.domain.request.GroupMemberSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.GroupMemberResponse;
import com.nbsaas.boot.ad.api.domain.simple.GroupMemberSimple;
import com.nbsaas.boot.ad.api.apis.GroupMemberApi;
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
@RequestMapping("/groupMember")
public class GroupMemberController {


    @Resource
    private GroupMemberApi groupMemberApi;


    @RequestMapping("/search")
    public PageResponse <GroupMemberSimple> search(GroupMemberSearchRequest request) {
        return groupMemberApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<GroupMemberSimple> list(GroupMemberSearchRequest request) {
        return groupMemberApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <GroupMemberResponse> create(@Validated(AddOperator.class) GroupMemberDataRequest request) {
        return groupMemberApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<GroupMemberResponse> update(@Validated(UpdateOperator.class) GroupMemberDataRequest request) {
       return groupMemberApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) GroupMemberDataRequest request) {
        return groupMemberApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <GroupMemberResponse> view(@Validated(ViewOperator.class) GroupMemberDataRequest  request) {
        return groupMemberApi.view(request);
    }
}