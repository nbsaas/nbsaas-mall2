package com.nbsaas.life.user.api.apis;

import com.nbsaas.life.user.api.domain.request.UserCityDataRequest;
import com.nbsaas.life.user.api.domain.simple.UserCitySimple;
import com.nbsaas.life.user.api.domain.response.UserCityResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserCityApi extends BaseApi<UserCityResponse, UserCitySimple, UserCityDataRequest> {


}
