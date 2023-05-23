package com.nbsaas.life.system.api.apis;

import com.nbsaas.life.system.api.domain.request.ErrorLogDataRequest;
import com.nbsaas.life.system.api.domain.simple.ErrorLogSimple;
import com.nbsaas.life.system.api.domain.response.ErrorLogResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ErrorLogApi extends BaseApi<ErrorLogResponse, ErrorLogSimple, ErrorLogDataRequest> {


}
