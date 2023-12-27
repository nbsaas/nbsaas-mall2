package com.nbsaas.boot.controller.area;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.area.api.domain.request.AreaRequest;
import com.nbsaas.boot.area.api.domain.request.AreaSearch;
import com.nbsaas.boot.area.api.domain.response.AreaResponse;
import com.nbsaas.boot.area.api.domain.simple.AreaSimple;
import com.nbsaas.boot.area.api.apis.AreaApi;
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
@RequestMapping("/area")
public class AreaController {


    @Resource
    private AreaApi areaApi;


    @RequiresPermissions("area")
    @RequestMapping("/search")
    public PageResponse <AreaSimple> search(AreaSearch request) {
        return areaApi.search(request);
    }

    @RequiresPermissions("area")
    @RequestMapping("/list")
    public ListResponse<AreaSimple> list(AreaSearch request) {
        return areaApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("area")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <AreaResponse> create(@Validated(AddOperator.class) AreaRequest request) {
        return areaApi.create(request);
    }

   @RequiresPermissions("area")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<AreaResponse> update(@Validated(UpdateOperator.class) AreaRequest request) {
       return areaApi.update(request);
   }

    @RequiresPermissions("area")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) AreaRequest request) {
        return areaApi.delete(request);
    }

    @RequiresPermissions("area")
    @RequestMapping("/view")
    public ResponseObject <AreaResponse> view(@Validated(ViewOperator.class) AreaRequest  request) {
        return areaApi.view(request);
    }
}