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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
*  前端控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/area")
public class AreaFrontController {


    @Resource
    private AreaApi areaApi;


    @RequestMapping("/search")
    public PageResponse<AreaSimple> search(AreaSearch request) {
        return areaApi.search(request);
    }

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
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<AreaResponse> create(@Validated(AddOperator.class) AreaRequest request) {
        return areaApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <AreaResponse> update(@Validated(UpdateOperator.class) AreaRequest request) {
        return areaApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) AreaRequest request) {
     return areaApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<AreaResponse> view(@Validated(ViewOperator.class) AreaRequest request) {
        return areaApi.view(request);
    }
}