package com.nbsaas.life.user.ext.apis;


import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.user.api.domain.response.UserInfoResponse;
import com.nbsaas.life.user.ext.domain.request.UserLoginRequest;
import com.nbsaas.life.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.life.user.ext.domain.response.UserInfoExtResponse;

public interface UserExtApi {


    ResponseObject<Boolean> checkRegister(UserRegisterRequest request);


    /**
     * 注册功能
     *
     * @param request
     * @return
     */
    ResponseObject<UserInfoResponse> register(UserRegisterRequest request);


    ResponseObject<UserInfoExtResponse> login(UserLoginRequest request);



}
