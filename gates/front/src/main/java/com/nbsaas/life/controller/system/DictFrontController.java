package com.nbsaas.life.controller.system;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.system.api.apis.DictApi;
import com.nbsaas.life.system.api.domain.request.DictDataRequest;
import com.nbsaas.life.system.api.domain.request.DictSearchRequest;
import com.nbsaas.life.system.api.domain.response.DictResponse;
import com.nbsaas.life.system.api.domain.simple.DictSimple;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/dict")
public class DictFrontController {


    @Resource
    private DictApi dictApi;


    @RequestMapping("/search")
    public PageResponse
            <DictSimple> search(DictSearchRequest request) {
        return dictApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse
            <DictSimple> list(DictSearchRequest request) {
        return dictApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject
            <DictResponse> create(@Validated(AddOperator.class) DictDataRequest request) {
        return dictApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject
            <DictResponse> update(@Validated(UpdateOperator.class) DictDataRequest
                                          request) {
        return dictApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) DictDataRequest
                                            request) {
        return dictApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject
            <DictResponse> view(@Validated(ViewOperator.class) DictDataRequest
                                        request) {
        return dictApi.view(request);
    }
}
