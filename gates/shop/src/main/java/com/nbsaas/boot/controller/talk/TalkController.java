package com.nbsaas.boot.controller.talk;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.talk.api.domain.request.TalkRequest;
import com.nbsaas.boot.talk.api.domain.request.TalkSearch;
import com.nbsaas.boot.talk.api.domain.response.TalkResponse;
import com.nbsaas.boot.talk.api.domain.simple.TalkSimple;
import com.nbsaas.boot.talk.api.apis.TalkApi;
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
@RequestMapping("/talk")
public class TalkController {


    @Resource
    private TalkApi talkApi;


    @RequiresPermissions("talk")
    @RequestMapping("/search")
    public PageResponse <TalkSimple> search(TalkSearch request) {
        return talkApi.search(request);
    }

    @RequiresPermissions("talk")
    @RequestMapping("/list")
    public ListResponse<TalkSimple> list(TalkSearch request) {
        return talkApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("talk")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TalkResponse> create(@Validated(AddOperator.class) TalkRequest request) {
        return talkApi.create(request);
    }

   @RequiresPermissions("talk")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TalkResponse> update(@Validated(UpdateOperator.class) TalkRequest request) {
       return talkApi.update(request);
   }

    @RequiresPermissions("talk")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TalkRequest request) {
        return talkApi.delete(request);
    }

    @RequiresPermissions("talk")
    @RequestMapping("/view")
    public ResponseObject <TalkResponse> view(@Validated(ViewOperator.class) TalkRequest  request) {
        return talkApi.view(request);
    }
}