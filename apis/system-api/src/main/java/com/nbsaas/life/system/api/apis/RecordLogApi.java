package com.nbsaas.life.system.api.apis;

import com.nbsaas.life.system.api.domain.request.RecordLogDataRequest;
import com.nbsaas.life.system.api.domain.simple.RecordLogSimple;
import com.nbsaas.life.system.api.domain.response.RecordLogResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface RecordLogApi extends BaseApi<RecordLogResponse, RecordLogSimple, RecordLogDataRequest> {


}
