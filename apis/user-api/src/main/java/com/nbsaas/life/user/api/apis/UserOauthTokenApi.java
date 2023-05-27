package com.nbsaas.life.user.api.apis;

import com.nbsaas.life.user.api.domain.request.UserOauthTokenDataRequest;
import com.nbsaas.life.user.api.domain.simple.UserOauthTokenSimple;
import com.nbsaas.life.user.api.domain.response.UserOauthTokenResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserOauthTokenApi extends BaseApi<UserOauthTokenResponse, UserOauthTokenSimple, UserOauthTokenDataRequest> {


}
