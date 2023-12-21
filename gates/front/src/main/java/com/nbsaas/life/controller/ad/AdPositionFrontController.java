package com.nbsaas.life.controller.ad;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.life.ad.api.domain.request.AdPositionRequest;
import com.nbsaas.life.ad.api.domain.request.AdPositionSearch;
import com.nbsaas.life.ad.api.domain.response.AdPositionResponse;
import com.nbsaas.life.ad.api.domain.simple.AdPositionSimple;
import com.nbsaas.life.ad.api.apis.AdPositionApi;
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
@RequestMapping("/adPosition")
public class AdPositionFrontController {


    @Resource
    private AdPositionApi adPositionApi;


    @RequestMapping("/search")
   public PageResponse<AdPositionSimple> search(AdPositionSearch request) {
        return adPositionApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <AdPositionSimple> list(AdPositionSearch request) {
        return adPositionApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<AdPositionResponse> create(@Validated(AddOperator.class) AdPositionRequest request) {
       return adPositionApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <AdPositionResponse> update(@Validated(UpdateOperator.class) AdPositionRequest request) {
         return adPositionApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) AdPositionRequest request) {
        return adPositionApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <AdPositionResponse> view(@Validated(ViewOperator.class) AdPositionRequest request) {
         return adPositionApi.view(request);
    }
}
