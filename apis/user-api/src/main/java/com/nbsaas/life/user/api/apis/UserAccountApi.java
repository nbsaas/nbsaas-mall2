package com.nbsaas.life.user.api.apis;

import com.nbsaas.life.user.api.domain.request.UserAccountDataRequest;
import com.nbsaas.life.user.api.domain.simple.UserAccountSimple;
import com.nbsaas.life.user.api.domain.response.UserAccountResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserAccountApi extends BaseApi<UserAccountResponse, UserAccountSimple, UserAccountDataRequest> {


}
