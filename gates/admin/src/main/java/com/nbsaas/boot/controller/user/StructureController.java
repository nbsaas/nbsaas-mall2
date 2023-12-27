package com.nbsaas.boot.controller.user;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.apis.StructureApi;
import com.nbsaas.boot.user.api.domain.request.StructureDataRequest;
import com.nbsaas.boot.user.api.domain.request.StructureSearchRequest;
import com.nbsaas.boot.user.api.domain.response.StructureResponse;
import com.nbsaas.boot.user.api.domain.simple.StructureSimple;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对外控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/structure")
public class StructureController {


    @Resource
    private StructureApi structureApi;


    @RequestMapping("/search")
    public PageResponse<StructureSimple> search(StructureSearchRequest request) {
        return structureApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<StructureSimple> list(StructureSearchRequest request) {
        return structureApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<StructureResponse> create(@Validated(AddOperator.class) StructureDataRequest request) {
        return structureApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<StructureResponse> update(@Validated(UpdateOperator.class) StructureDataRequest request) {
        return structureApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) StructureDataRequest request) {
        return structureApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<StructureResponse> view(@Validated(ViewOperator.class) StructureDataRequest request) {
        return structureApi.view(request);
    }
}