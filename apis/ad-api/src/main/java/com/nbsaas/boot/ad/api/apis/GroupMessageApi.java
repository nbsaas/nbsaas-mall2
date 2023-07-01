package com.nbsaas.boot.ad.api.apis;

import com.nbsaas.boot.ad.api.domain.request.GroupMessageDataRequest;
import com.nbsaas.boot.ad.api.domain.simple.GroupMessageSimple;
import com.nbsaas.boot.ad.api.domain.response.GroupMessageResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface GroupMessageApi extends BaseApi<GroupMessageResponse, GroupMessageSimple, GroupMessageDataRequest> {


}
