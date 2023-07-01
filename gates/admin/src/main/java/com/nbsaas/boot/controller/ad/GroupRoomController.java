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
import com.nbsaas.boot.ad.api.domain.request.GroupRoomDataRequest;
import com.nbsaas.boot.ad.api.domain.request.GroupRoomSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.GroupRoomResponse;
import com.nbsaas.boot.ad.api.domain.simple.GroupRoomSimple;
import com.nbsaas.boot.ad.api.apis.GroupRoomApi;
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
@RequestMapping("/groupRoom")
public class GroupRoomController {


    @Resource
    private GroupRoomApi groupRoomApi;


    @RequestMapping("/search")
    public PageResponse <GroupRoomSimple> search(GroupRoomSearchRequest request) {
        return groupRoomApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<GroupRoomSimple> list(GroupRoomSearchRequest request) {
        return groupRoomApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <GroupRoomResponse> create(@Validated(AddOperator.class) GroupRoomDataRequest request) {
        return groupRoomApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<GroupRoomResponse> update(@Validated(UpdateOperator.class) GroupRoomDataRequest request) {
       return groupRoomApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) GroupRoomDataRequest request) {
        return groupRoomApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <GroupRoomResponse> view(@Validated(ViewOperator.class) GroupRoomDataRequest  request) {
        return groupRoomApi.view(request);
    }
}