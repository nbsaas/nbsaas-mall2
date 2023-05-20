package com.nbsaas.life.user.api.apis;

import com.nbsaas.life.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.life.user.api.domain.simple.UserInfoSimple;
import com.nbsaas.life.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserInfoApi extends BaseApi<UserInfoResponse, UserInfoSimple, UserInfoDataRequest> {


}
