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
import com.nbsaas.boot.ad.api.domain.request.AdRequest;
import com.nbsaas.boot.ad.api.domain.request.AdSearch;
import com.nbsaas.boot.ad.api.domain.response.AdResponse;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;
import com.nbsaas.boot.ad.api.apis.AdApi;
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
@RequestMapping("/ad")
public class AdController {


    @Resource
    private AdApi adApi;


    @RequiresPermissions("ad")
    @RequestMapping("/search")
    public PageResponse <AdSimple> search(AdSearch request) {
        return adApi.search(request);
    }

    @RequiresPermissions("ad")
    @RequestMapping("/list")
    public ListResponse<AdSimple> list(AdSearch request) {
        return adApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("ad")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <AdResponse> create(@Validated(AddOperator.class) AdRequest request) {
        return adApi.create(request);
    }

   @RequiresPermissions("ad")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<AdResponse> update(@Validated(UpdateOperator.class) AdRequest request) {
       return adApi.update(request);
   }

    @RequiresPermissions("ad")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) AdRequest request) {
        return adApi.delete(request);
    }

    @RequiresPermissions("ad")
    @RequestMapping("/view")
    public ResponseObject <AdResponse> view(@Validated(ViewOperator.class) AdRequest  request) {
        return adApi.view(request);
    }
}