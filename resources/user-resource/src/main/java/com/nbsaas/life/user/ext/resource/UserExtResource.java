package com.nbsaas.life.user.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.request.LongId;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.user.api.apis.UserAccountApi;
import com.nbsaas.life.user.api.apis.UserInfoApi;
import com.nbsaas.life.user.api.apis.UserPasswordApi;
import com.nbsaas.life.user.api.domain.enums.AccountType;
import com.nbsaas.life.user.api.domain.enums.SecurityType;
import com.nbsaas.life.user.api.domain.field.UserAccountField;
import com.nbsaas.life.user.api.domain.request.UserAccountDataRequest;
import com.nbsaas.life.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.life.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.life.user.api.domain.response.UserAccountResponse;
import com.nbsaas.life.user.api.domain.response.UserInfoResponse;
import com.nbsaas.life.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.life.user.data.entity.UserInfo;
import com.nbsaas.life.user.ext.apis.PasswordApi;
import com.nbsaas.life.user.ext.apis.UserExtApi;
import com.nbsaas.life.user.ext.domain.request.UserLoginRequest;
import com.nbsaas.life.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.life.user.ext.domain.response.PasswordResponse;
import com.nbsaas.life.user.ext.domain.response.UserInfoExtResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class UserExtResource implements UserExtApi {


    @Resource
    private UserAccountApi userAccountApi;

    @Resource
    private UserPasswordApi userPasswordApi;

    @Resource
    private UserInfoApi userInfoApi;

    @Resource
    private PasswordApi passwordApi;


    @Override
    public ResponseObject<Boolean> checkRegister(UserRegisterRequest request) {
        ResponseObject<Boolean> result = new ResponseObject<>();
        Long num = userAccountApi.countData(Filter.eq(UserAccountField.username, request.getUsername()),
                Filter.eq(UserAccountField.accountType, request.getAccountType()));
        if (num == null) {
            num = 0L;
        }
        if (num > 0) {
            result.setData(false);
        } else {
            result.setData(true);
        }
        return result;
    }


    @Transactional
    @Override
    public ResponseObject<UserInfoResponse> register(UserRegisterRequest request) {
        ResponseObject<UserInfoResponse> result = new ResponseObject<>();
        if (request.getAccountType() == null) {
            request.setAccountType(AccountType.account);
        }
        /**
         * 描述：查询user账户是否被备注
         */
        Long num = userAccountApi.countData(Filter.eq(UserAccountField.accountType, request.getAccountType()),
                Filter.eq(UserAccountField.username, request.getUsername()));
        if (num == null) {
            num = 0L;
        }
        if (num > 0) {
            result.setCode(503);
            result.setMsg("该用户名已被使用");
            return result;
        }
        /**
         * 描述：user表写入
         */
        UserInfoDataRequest userForm = new UserInfoDataRequest();
        userForm.setName(request.getUsername());
        userForm.setPhone(request.getUsername());
        UserInfoResponse response = userInfoApi.createData(userForm);

        /**
         * 描述：user账户表写入
         */
        UserAccountDataRequest userAccount = new UserAccountDataRequest();
        userAccount.setAccountType(AccountType.phone);
        userAccount.setUsername(request.getUsername());
        userAccount.setLoginSize(0);
        userAccount.setUser(response.getId());
        userAccountApi.createData(userAccount);


        PasswordResponse password = passwordApi.password(request);

        UserPasswordDataRequest userPassword = new UserPasswordDataRequest();
        userPassword.setSalt(password.getSalt());
        userPassword.setPassword(password.getPassword());
        userPassword.setUser(response.getId());
        userPassword.setSecurityType(SecurityType.account);
        userPassword.setAddDate(new Date());
        userPassword.setLastDate(new Date());
        userPassword.setCheckSize(0);
        userPasswordApi.createData(userPassword);

        return result;
    }

    @Transactional
    @Override
    public ResponseObject<UserInfoExtResponse> login(UserLoginRequest request) {
        ResponseObject<UserInfoExtResponse> result = new ResponseObject<>();
        if (request.getAccountType() == null) {
            request.setAccountType(AccountType.phone);
        }
        UserAccountResponse account = userAccountApi.oneData(
                Filter.eq(UserAccountField.username, request.getUsername()),
                Filter.eq(UserAccountField.accountType, request.getAccountType())
        );
        if (account == null) {
            result.setCode(501);
            result.setMsg("账号不存在");
            return result;
        }
        UserInfo info = new UserInfo();
        info.setId(account.getUser());
        UserPasswordResponse password = userPasswordApi.oneData(Filter.eq("user.id", account.getUser()));
        if (password == null) {
            result.setCode(502);
            result.setMsg("密码不存在");
            return result;
        }
        UserRegisterRequest req=new UserRegisterRequest();
        req.setPassword(request.getPassword());
        req.setSalt(password.getSalt());
        PasswordResponse pwd = passwordApi.passwordBySalt(req);
        if (!pwd.getPassword().equals(password.getPassword())) {
            result.setCode(503);
            result.setMsg("密码错误");
            return result;
        }
        ResponseObject<UserInfoResponse> res = userInfoApi.view(new LongId(account.getUser()));
        if (res.getCode() != 200) {
            result.setCode(504);
            result.setMsg("没有用户信息");
            return result;
        }

        UserInfoExtResponse extResponse = new UserInfoExtResponse();
        BeanUtils.copyProperties(res.getData(), extResponse);

        result.setData(extResponse);
        return result;
    }
}
