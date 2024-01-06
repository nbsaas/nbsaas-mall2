package com.nbsaas.boot.controller.user;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.nbsaas.boot.app.ext.apis.AppMenuExtApi;
import com.nbsaas.boot.app.ext.domain.simple.AppMenuExtSimple;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.security.token.DataToken;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffResponse;
import com.nbsaas.boot.shop.ext.apis.ShopStaffExtApi;
import com.nbsaas.boot.system.api.apis.ApplicationApi;
import com.nbsaas.boot.system.ext.apis.ApplicationMenuExtApi;
import com.nbsaas.boot.system.ext.domain.simple.ApplicationMenuExtSimple;
import com.nbsaas.boot.user.api.apis.UserInfoApi;
import com.nbsaas.boot.user.api.domain.enums.AccountType;
import com.nbsaas.boot.user.api.domain.enums.LoginState;
import com.nbsaas.boot.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserInfoSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.api.domain.simple.UserInfoSimple;
import com.nbsaas.boot.user.ext.apis.UserExtApi;
import com.nbsaas.boot.user.ext.domain.request.UserLoginOatuthRequest;
import com.nbsaas.boot.user.ext.domain.request.UserLoginRequest;
import com.nbsaas.boot.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.boot.user.ext.domain.request.UserUpdatePasswordRequest;
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
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 前端控制器
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoFrontController {


    @Resource
    private UserInfoApi userInfoApi;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Resource
    private ApplicationApi applicationApi;


    @Resource
    private AppMenuExtApi appMenuExtApi;

    @RequestMapping("/tree")
    public ListResponse<AppMenuExtSimple> tree(Long app) {
        ListResponse<AppMenuExtSimple> result=new ListResponse<>();

        ShopStaffResponse user = UserUtils.user();
//        ApplicationDataRequest req=new ApplicationDataRequest();
//        req.setAppKey("shop");
//        ResponseObject<ApplicationResponse> app = applicationApi.viewByOne(req);
//        if (app.getCode()!=200){
//            result.setCode(501);
//            result.setMsg("该应用没有启用");
//            return result;
//        }
        return appMenuExtApi.tree(app,user.getId());

    }

    @Resource
    private ApplicationMenuExtApi applicationMenuExtApi;

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

    @RequestMapping("/loginOauth")
    public ResponseObject<UserInfoExtResponse> loginOauth(UserLoginOatuthRequest request, HttpServletRequest servletRequest) {
        ResponseObject<UserInfoExtResponse> result = userExtApi.loginOauth(request);
        if (result.getCode() != 200) {
            return result;
        }

        DataToken<UserInfoResponse> dataToken = new DataToken<>();
        dataToken.setData(result.getData());
        SecurityUtils.getSubject().login(dataToken);

        result.getData().setSessionId(String.valueOf(SecurityUtils.getSubject().getSession().getId()));

        UserLoginLogDataRequest loginSuccessEvent = new UserLoginLogDataRequest();
        loginSuccessEvent.setAccount("");
        loginSuccessEvent.setPassword("");
        loginSuccessEvent.setUser(result.getData().getId());
        loginSuccessEvent.setIp(getIpAddr(servletRequest));
        loginSuccessEvent.setState(LoginState.success);
        loginSuccessEvent.setStoreState(StoreState.normal);
        loginSuccessEvent.setClient("wx_mini");
        applicationEventPublisher.publishEvent(loginSuccessEvent);

        return result;
    }

    @Resource
    private UserExtApi userExtApi;

    @Resource
    private ShopStaffExtApi shopStaffExtApi;



    private final Cache<String, Object> cache = CacheBuilder.newBuilder()
            // 最大3个 //Cache中存储的对象,写入3秒后过期
            .maximumSize(100).expireAfterWrite(10,
                    //记录命中率 失效通知
                    TimeUnit.SECONDS).recordStats().removalListener(
                    notification -> {
                        System.out.println(notification.getKey() + ":" + notification.getCause());
                        System.out.println(new Date());

                    }
            ).build();


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
            loginFailEvent.setClient("shop front");
            applicationEventPublisher.publishEvent(loginFailEvent);
            return result;
        }
        //检查该用户是否有店铺
        ResponseObject<ShopStaffResponse> res = shopStaffExtApi.findByUserId(result.getData().getId());
        if (res.getCode() != 200) {
            result.setCode(res.getCode());
            result.setMsg(res.getMsg());
            return result;
        }

        DataToken<ShopStaffResponse> dataToken = new DataToken<>();

        dataToken.setData(res.getData());
        SecurityUtils.getSubject().login(dataToken);
        result.getData().setSessionId(String.valueOf(SecurityUtils.getSubject().getSession().getId()));

        UserLoginLogDataRequest loginSuccessEvent=new UserLoginLogDataRequest();
        loginSuccessEvent.setAccount(request.getUsername());
        loginSuccessEvent.setPassword("");
        loginSuccessEvent.setUser(result.getData().getId());
        loginSuccessEvent.setIp(getIpAddr(servletRequest));
        loginSuccessEvent.setState(LoginState.success);
        loginSuccessEvent.setStoreState(StoreState.normal);
        loginSuccessEvent.setClient("shop front");
        applicationEventPublisher.publishEvent(loginSuccessEvent);
        return result;
    }

    @RequestMapping("/updatePassword")
    public ResponseObject<?> updatePassword(UserUpdatePasswordRequest request) {
        request.setId(UserUtils.user().getId());
        return userExtApi.updatePassword(request);
    }
    @RequestMapping("/checkRegister")
    public ResponseObject<Boolean> checkRegister(UserRegisterRequest request) {
        request.setAccountType(AccountType.phone);
        return userExtApi.checkRegister(request);
    }

    @RequestMapping("/register")
    public ResponseObject<UserInfoResponse> register(@Validated UserRegisterRequest request) {
        ResponseObject<UserInfoResponse> result = new ResponseObject<>();

        request.setAccountType(AccountType.phone);
        Object lock = cache.getIfPresent(request.getUsername());
        if (lock == null) {
            lock = new Object();
            cache.put(request.getUsername(), lock);
        }
        synchronized (lock) {
            result = userExtApi.register(request);
        }
        return result;
    }


    @RequestMapping("/search")
    public PageResponse<UserInfoSimple> search(UserInfoSearchRequest request) {
        return userInfoApi.search(request);
    }


    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<UserInfoResponse> update(@Validated(UpdateOperator.class) UserInfoDataRequest request) {
        request.setId(UserUtils.user().getStaff());
        return userInfoApi.update(request);
    }


    @RequiresUser
    @RequestMapping("/current")
    public ResponseObject<UserInfoResponse> current() {
        UserInfoDataRequest request = new UserInfoDataRequest();
        request.setId(UserUtils.user().getStaff());
        return userInfoApi.view(request);
    }


}
