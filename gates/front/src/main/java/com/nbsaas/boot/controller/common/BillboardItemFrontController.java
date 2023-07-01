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
import com.nbsaas.boot.common.api.domain.request.BillboardItemDataRequest;
import com.nbsaas.boot.common.api.domain.request.BillboardItemSearchRequest;
import com.nbsaas.boot.common.api.domain.response.BillboardItemResponse;
import com.nbsaas.boot.common.api.domain.simple.BillboardItemSimple;
import com.nbsaas.boot.common.api.apis.BillboardItemApi;
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
@RequestMapping("/billboardItem")
public class BillboardItemFrontController {


    @Resource
    private BillboardItemApi billboardItemApi;


    @RequestMapping("/search")
    public PageResponse<BillboardItemSimple> search(BillboardItemSearchRequest request) {
        return billboardItemApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<BillboardItemSimple> list(BillboardItemSearchRequest request) {
        return billboardItemApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<BillboardItemResponse> create(@Validated(AddOperator.class) BillboardItemDataRequest request) {
        return billboardItemApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject <BillboardItemResponse> update(@Validated(UpdateOperator.class) BillboardItemDataRequest request) {
        return billboardItemApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) BillboardItemDataRequest request) {
     return billboardItemApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<BillboardItemResponse> view(@Validated(ViewOperator.class) BillboardItemDataRequest request) {
        return billboardItemApi.view(request);
    }
}