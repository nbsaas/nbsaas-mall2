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
import com.nbsaas.boot.ad.api.domain.request.AdPositionRequest;
import com.nbsaas.boot.ad.api.domain.request.AdPositionSearch;
import com.nbsaas.boot.ad.api.domain.response.AdPositionResponse;
import com.nbsaas.boot.ad.api.domain.simple.AdPositionSimple;
import com.nbsaas.boot.ad.api.apis.AdPositionApi;
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
@RequestMapping("/adPosition")
public class AdPositionController {


    @Resource
    private AdPositionApi adPositionApi;


    @RequiresPermissions("adPosition")
    @RequestMapping("/search")
    public PageResponse <AdPositionSimple> search(AdPositionSearch request) {
        return adPositionApi.search(request);
    }

    @RequiresPermissions("adPosition")
    @RequestMapping("/list")
    public ListResponse<AdPositionSimple> list(AdPositionSearch request) {
        return adPositionApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("adPosition")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <AdPositionResponse> create(@Validated(AddOperator.class) AdPositionRequest request) {
        return adPositionApi.create(request);
    }

   @RequiresPermissions("adPosition")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<AdPositionResponse> update(@Validated(UpdateOperator.class) AdPositionRequest request) {
       return adPositionApi.update(request);
   }

    @RequiresPermissions("adPosition")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) AdPositionRequest request) {
        return adPositionApi.delete(request);
    }

    @RequiresPermissions("adPosition")
    @RequestMapping("/view")
    public ResponseObject <AdPositionResponse> view(@Validated(ViewOperator.class) AdPositionRequest  request) {
        return adPositionApi.view(request);
    }
}