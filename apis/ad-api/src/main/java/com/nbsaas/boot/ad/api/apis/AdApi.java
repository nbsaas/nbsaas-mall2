package com.nbsaas.boot.ad.api.apis;

import com.nbsaas.boot.ad.api.domain.request.AdRequest;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;
import com.nbsaas.boot.ad.api.domain.response.AdResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface AdApi extends BaseApi<AdResponse, AdSimple, AdRequest> {


}
