package com.nbsaas.boot.controller.user;

import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.security.token.DataToken;
import com.nbsaas.boot.system.ext.apis.MenuExtApi;
import com.nbsaas.boot.system.ext.domain.simple.MenuExtSimple;
import com.nbsaas.boot.user.api.apis.UserInfoApi;
import com.nbsaas.boot.user.api.domain.enums.AccountType;
import com.nbsaas.boot.user.api.domain.enums.LoginState;
import com.nbsaas.boot.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserInfoSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.api.domain.simple.UserInfoSimple;
import com.nbsaas.boot.user.ext.apis.UserExtApi;
import com.nbsaas.boot.user.ext.domain.request.UserLoginRequest;
import com.nbsaas.boot.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.boot.user.ext.domain.response.UserInfoExtResponse;
import com.nbsaas.boot.utils.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 前端控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserInfoApi userInfoApi;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Resource
    private MenuExtApi menuExtApi;

    @RequestMapping("/tree")
    public ListResponse<MenuExtSimple> tree() {
        return menuExtApi.tree(UserUtils.user().getId(),1);
    }


    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.hasText(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.hasText(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    @Resource
    private UserExtApi userExtApi;



    @RequestMapping("/login")
    public ResponseObject<UserInfoExtResponse> login(@Validated UserLoginRequest request,HttpServletRequest servletRequest) {
        ResponseObject<UserInfoExtResponse> result =userExtApi.login(request);
        if (result.getCode()!=200){
            UserLoginLogDataRequest loginFailEvent=new UserLoginLogDataRequest();
            loginFailEvent.setAccount(request.getUsername());
            loginFailEvent.setPassword(request.getPassword());
            loginFailEvent.setIp(getIpAddr(servletRequest));
            loginFailEvent.setState(LoginState.fail);
            loginFailEvent.setStoreState(StoreState.normal);
            loginFailEvent.setClient("web front");
            applicationEventPublisher.publishEvent(loginFailEvent);
            return result;
        }

        DataToken<UserInfoResponse> dataToken = new DataToken<>();

        dataToken.setData(result.getData());
        SecurityUtils.getSubject().login(dataToken);
        result.getData().setSessionId(String.valueOf(SecurityUtils.getSubject().getSession().getId()));

        UserLoginLogDataRequest loginSuccessEvent=new UserLoginLogDataRequest();
        loginSuccessEvent.setAccount(request.getUsername());
        loginSuccessEvent.setPassword("");
        loginSuccessEvent.setUser(result.getData().getId());
        loginSuccessEvent.setIp(getIpAddr(servletRequest));
        loginSuccessEvent.setState(LoginState.success);
        loginSuccessEvent.setStoreState(StoreState.normal);
        loginSuccessEvent.setClient("web admin");
        applicationEventPublisher.publishEvent(loginSuccessEvent);
        return result;
    }

    @RequestMapping("/checkRegister")
    public ResponseObject<Boolean> checkRegister(UserRegisterRequest request) {
        request.setAccountType(AccountType.phone);
        return userExtApi.checkRegister(request);
    }

    @RequestMapping("/register")
    public ResponseObject<UserInfoResponse> register(@Validated UserRegisterRequest request) {
        return userExtApi.register(request);
    }


    @RequestMapping("/search")
    public PageResponse<UserInfoSimple> search(UserInfoSearchRequest request) {
        return userInfoApi.search(request);
    }

    @RequiresUser
    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<UserInfoResponse> update(@Validated(UpdateOperator.class) UserInfoDataRequest request) {
        request.setId(UserUtils.user().getId());
        return userInfoApi.update(request);
    }


    @RequiresUser
    @RequestMapping("/current")
    public ResponseObject<UserInfoResponse> current() {
        UserInfoDataRequest request = new UserInfoDataRequest();
        request.setId(UserUtils.user().getId());
        return userInfoApi.view(request);
    }

    @RequiresUser
    @RequestMapping("/logout")
    public ResponseObject<?> logout() {
        SecurityUtils.getSubject().logout();
        return ResponseObject.success();
    }
}
