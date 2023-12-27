package com.nbsaas.boot.controller.user;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.apis.UserLoginLogApi;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserLoginLogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserLoginLogSimple;
import com.nbsaas.boot.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对外控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/userLoginLog")
public class UserLoginLogController {


    @Resource
    private UserLoginLogApi userLoginLogApi;


    @RequiresPermissions("userLoginLog")
    @RequestMapping("/search")
    public PageResponse<UserLoginLogSimple> search(UserLoginLogSearchRequest request) {
        return userLoginLogApi.search(request);
    }

    @RequiresPermissions("userLoginLog")
    @RequestMapping("/my")
    public PageResponse<UserLoginLogSimple> my(UserLoginLogSearchRequest request) {
        request.setUserId(UserUtils.user().getId());
        return userLoginLogApi.search(request);
    }

    @RequiresPermissions("userLoginLog")
    @RequestMapping("/list")
    public ListResponse<UserLoginLogSimple> list(UserLoginLogSearchRequest request) {
        return userLoginLogApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */

    @RequiresPermissions("userLoginLog")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<UserLoginLogResponse> create(@Validated(AddOperator.class) UserLoginLogDataRequest request) {
        return userLoginLogApi.create(request);
    }

    @RequiresPermissions("userLoginLog")
    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<UserLoginLogResponse> update(@Validated(UpdateOperator.class) UserLoginLogDataRequest request) {
        return userLoginLogApi.update(request);
    }

    @RequiresPermissions("userLoginLog")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserLoginLogDataRequest request) {
        return userLoginLogApi.delete(request);
    }

    @RequiresPermissions("userLoginLog")
    @RequestMapping("/view")
    public ResponseObject<UserLoginLogResponse> view(@Validated(ViewOperator.class) UserLoginLogDataRequest request) {
        return userLoginLogApi.view(request);
    }
}