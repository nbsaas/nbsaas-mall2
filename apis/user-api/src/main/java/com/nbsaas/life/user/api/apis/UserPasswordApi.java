package com.nbsaas.life.user.api.apis;

import com.nbsaas.life.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.life.user.api.domain.simple.UserPasswordSimple;
import com.nbsaas.life.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserPasswordApi extends BaseApi<UserPasswordResponse, UserPasswordSimple, UserPasswordDataRequest> {


}
