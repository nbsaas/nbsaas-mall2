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
import com.nbsaas.boot.talk.api.domain.request.TalkReplyRequest;
import com.nbsaas.boot.talk.api.domain.request.TalkReplySearch;
import com.nbsaas.boot.talk.api.domain.response.TalkReplyResponse;
import com.nbsaas.boot.talk.api.domain.simple.TalkReplySimple;
import com.nbsaas.boot.talk.api.apis.TalkReplyApi;
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
@RequestMapping("/talkReply")
public class TalkReplyController {


    @Resource
    private TalkReplyApi talkReplyApi;


    @RequiresPermissions("talkReply")
    @RequestMapping("/search")
    public PageResponse <TalkReplySimple> search(TalkReplySearch request) {
        return talkReplyApi.search(request);
    }

    @RequiresPermissions("talkReply")
    @RequestMapping("/list")
    public ListResponse<TalkReplySimple> list(TalkReplySearch request) {
        return talkReplyApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("talkReply")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TalkReplyResponse> create(@Validated(AddOperator.class) TalkReplyRequest request) {
        return talkReplyApi.create(request);
    }

   @RequiresPermissions("talkReply")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TalkReplyResponse> update(@Validated(UpdateOperator.class) TalkReplyRequest request) {
       return talkReplyApi.update(request);
   }

    @RequiresPermissions("talkReply")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TalkReplyRequest request) {
        return talkReplyApi.delete(request);
    }

    @RequiresPermissions("talkReply")
    @RequestMapping("/view")
    public ResponseObject <TalkReplyResponse> view(@Validated(ViewOperator.class) TalkReplyRequest  request) {
        return talkReplyApi.view(request);
    }
}