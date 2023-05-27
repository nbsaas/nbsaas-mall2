package com.nbsaas.life.user.api.apis;

import com.nbsaas.life.user.api.domain.request.UserOauthConfigDataRequest;
import com.nbsaas.life.user.api.domain.simple.UserOauthConfigSimple;
import com.nbsaas.life.user.api.domain.response.UserOauthConfigResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserOauthConfigApi extends BaseApi<UserOauthConfigResponse, UserOauthConfigSimple, UserOauthConfigDataRequest> {


}
