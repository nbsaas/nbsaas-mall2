package com.nbsaas.boot.shop.api.apis;

import com.nbsaas.boot.shop.api.domain.request.StaffRequest;
import com.nbsaas.boot.shop.api.domain.simple.StaffSimple;
import com.nbsaas.boot.shop.api.domain.response.StaffResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface StaffApi extends BaseApi<StaffResponse, StaffSimple, StaffRequest> {


}
