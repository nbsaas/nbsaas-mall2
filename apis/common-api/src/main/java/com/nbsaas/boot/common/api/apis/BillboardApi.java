package com.nbsaas.boot.common.api.apis;

import com.nbsaas.boot.common.api.domain.request.BillboardDataRequest;
import com.nbsaas.boot.common.api.domain.simple.BillboardSimple;
import com.nbsaas.boot.common.api.domain.response.BillboardResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface BillboardApi extends BaseApi<BillboardResponse, BillboardSimple, BillboardDataRequest> {


}
