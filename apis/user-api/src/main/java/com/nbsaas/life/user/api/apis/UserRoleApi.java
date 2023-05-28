package com.nbsaas.life.user.api.apis;

import com.nbsaas.life.user.api.domain.request.UserRoleDataRequest;
import com.nbsaas.life.user.api.domain.simple.UserRoleSimple;
import com.nbsaas.life.user.api.domain.response.UserRoleResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserRoleApi extends BaseApi<UserRoleResponse, UserRoleSimple, UserRoleDataRequest> {


}
