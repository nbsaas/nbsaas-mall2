package com.nbsaas.boot.controller.common;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.common.api.domain.request.BillboardDataRequest;
import com.nbsaas.boot.common.api.domain.request.BillboardSearchRequest;
import com.nbsaas.boot.common.api.domain.response.BillboardResponse;
import com.nbsaas.boot.common.api.domain.simple.BillboardSimple;
import com.nbsaas.boot.common.api.apis.BillboardApi;
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
@RequestMapping("/billboard")
public class BillboardFrontController {


    @Resource
    private BillboardApi billboardApi;


    @RequestMapping("/search")
    public PageResponse<BillboardSimple> search(BillboardSearchRequest request) {
        return billboardApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<BillboardSimple> list(BillboardSearchRequest request) {
        return billboardApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<BillboardResponse> create(@Validated(AddOperator.class) BillboardDataRequest request) {
        return billboardApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <BillboardResponse> update(@Validated(UpdateOperator.class) BillboardDataRequest request) {
        return billboardApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) BillboardDataRequest request) {
     return billboardApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<BillboardResponse> view(@Validated(ViewOperator.class) BillboardDataRequest request) {
        return billboardApi.view(request);
    }
}