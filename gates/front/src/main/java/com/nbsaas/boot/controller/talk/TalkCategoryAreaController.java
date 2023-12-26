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
import com.nbsaas.boot.talk.api.domain.request.TalkCategoryAreaRequest;
import com.nbsaas.boot.talk.api.domain.request.TalkCategoryAreaSearch;
import com.nbsaas.boot.talk.api.domain.response.TalkCategoryAreaResponse;
import com.nbsaas.boot.talk.api.domain.simple.TalkCategoryAreaSimple;
import com.nbsaas.boot.talk.api.apis.TalkCategoryAreaApi;
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
@RequestMapping("/talkCategoryArea")
public class TalkCategoryAreaController {


    @Resource
    private TalkCategoryAreaApi talkCategoryAreaApi;


    @RequiresPermissions("talkCategoryArea")
    @RequestMapping("/search")
    public PageResponse <TalkCategoryAreaSimple> search(TalkCategoryAreaSearch request) {
        return talkCategoryAreaApi.search(request);
    }

    @RequiresPermissions("talkCategoryArea")
    @RequestMapping("/list")
    public ListResponse<TalkCategoryAreaSimple> list(TalkCategoryAreaSearch request) {
        return talkCategoryAreaApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("talkCategoryArea")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TalkCategoryAreaResponse> create(@Validated(AddOperator.class) TalkCategoryAreaRequest request) {
        return talkCategoryAreaApi.create(request);
    }

   @RequiresPermissions("talkCategoryArea")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TalkCategoryAreaResponse> update(@Validated(UpdateOperator.class) TalkCategoryAreaRequest request) {
       return talkCategoryAreaApi.update(request);
   }

    @RequiresPermissions("talkCategoryArea")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TalkCategoryAreaRequest request) {
        return talkCategoryAreaApi.delete(request);
    }

    @RequiresPermissions("talkCategoryArea")
    @RequestMapping("/view")
    public ResponseObject <TalkCategoryAreaResponse> view(@Validated(ViewOperator.class) TalkCategoryAreaRequest  request) {
        return talkCategoryAreaApi.view(request);
    }
}