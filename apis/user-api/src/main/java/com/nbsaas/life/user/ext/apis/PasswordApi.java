package com.nbsaas.life.user.ext.apis;

import com.nbsaas.life.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.life.user.ext.domain.response.PasswordResponse;

public interface PasswordApi {


    /**
     * 生成加密后的密码
     *
     * @param request
     * @return
     */
    PasswordResponse password(UserRegisterRequest request);


    PasswordResponse passwordBySalt(UserRegisterRequest request);

}
