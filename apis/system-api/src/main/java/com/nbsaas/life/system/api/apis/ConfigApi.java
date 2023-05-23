package com.nbsaas.life.system.api.apis;

import com.nbsaas.life.system.api.domain.request.ConfigDataRequest;
import com.nbsaas.life.system.api.domain.simple.ConfigSimple;
import com.nbsaas.life.system.api.domain.response.ConfigResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ConfigApi extends BaseApi<ConfigResponse, ConfigSimple, ConfigDataRequest> {


}
