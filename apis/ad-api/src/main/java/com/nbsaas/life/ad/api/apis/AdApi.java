package com.nbsaas.life.ad.api.apis;

import com.nbsaas.life.ad.api.domain.request.AdDataRequest;
import com.nbsaas.life.ad.api.domain.simple.AdSimple;
import com.nbsaas.life.ad.api.domain.response.AdResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface AdApi extends BaseApi<AdResponse, AdSimple, AdDataRequest> {


}
