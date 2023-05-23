package com.nbsaas.life.system.api.apis;

import com.nbsaas.life.system.api.domain.request.MockDataRequest;
import com.nbsaas.life.system.api.domain.simple.MockSimple;
import com.nbsaas.life.system.api.domain.response.MockResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface MockApi extends BaseApi<MockResponse, MockSimple, MockDataRequest> {


}
