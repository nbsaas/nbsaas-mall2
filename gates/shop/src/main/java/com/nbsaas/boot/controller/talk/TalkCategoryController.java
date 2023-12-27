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
import com.nbsaas.boot.talk.api.domain.request.TalkCategoryRequest;
import com.nbsaas.boot.talk.api.domain.request.TalkCategorySearch;
import com.nbsaas.boot.talk.api.domain.response.TalkCategoryResponse;
import com.nbsaas.boot.talk.api.domain.simple.TalkCategorySimple;
import com.nbsaas.boot.talk.api.apis.TalkCategoryApi;
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
@RequestMapping("/talkCategory")
public class TalkCategoryController {


    @Resource
    private TalkCategoryApi talkCategoryApi;


    @RequiresPermissions("talkCategory")
    @RequestMapping("/search")
    public PageResponse <TalkCategorySimple> search(TalkCategorySearch request) {
        return talkCategoryApi.search(request);
    }

    @RequiresPermissions("talkCategory")
    @RequestMapping("/list")
    public ListResponse<TalkCategorySimple> list(TalkCategorySearch request) {
        return talkCategoryApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("talkCategory")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TalkCategoryResponse> create(@Validated(AddOperator.class) TalkCategoryRequest request) {
        return talkCategoryApi.create(request);
    }

   @RequiresPermissions("talkCategory")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TalkCategoryResponse> update(@Validated(UpdateOperator.class) TalkCategoryRequest request) {
       return talkCategoryApi.update(request);
   }

    @RequiresPermissions("talkCategory")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TalkCategoryRequest request) {
        return talkCategoryApi.delete(request);
    }

    @RequiresPermissions("talkCategory")
    @RequestMapping("/view")
    public ResponseObject <TalkCategoryResponse> view(@Validated(ViewOperator.class) TalkCategoryRequest  request) {
        return talkCategoryApi.view(request);
    }
}