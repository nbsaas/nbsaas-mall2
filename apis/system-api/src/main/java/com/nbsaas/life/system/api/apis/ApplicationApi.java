package com.nbsaas.life.system.api.apis;

import com.nbsaas.life.system.api.domain.request.ApplicationDataRequest;
import com.nbsaas.life.system.api.domain.simple.ApplicationSimple;
import com.nbsaas.life.system.api.domain.response.ApplicationResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ApplicationApi extends BaseApi<ApplicationResponse, ApplicationSimple, ApplicationDataRequest> {


}
