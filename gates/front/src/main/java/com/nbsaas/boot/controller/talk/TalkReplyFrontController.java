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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
*  前端控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/talkReply")
public class TalkReplyFrontController {


    @Resource
    private TalkReplyApi talkReplyApi;


    @RequestMapping("/search")
    public PageResponse<TalkReplySimple> search(TalkReplySearch request) {
        return talkReplyApi.search(request);
    }

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
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<TalkReplyResponse> create(@Validated(AddOperator.class) TalkReplyRequest request) {
        return talkReplyApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <TalkReplyResponse> update(@Validated(UpdateOperator.class) TalkReplyRequest request) {
        return talkReplyApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TalkReplyRequest request) {
     return talkReplyApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<TalkReplyResponse> view(@Validated(ViewOperator.class) TalkReplyRequest request) {
        return talkReplyApi.view(request);
    }
}