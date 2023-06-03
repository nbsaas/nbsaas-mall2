package com.nbsaas.life.system.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.life.system.api.domain.request.DictItemDataRequest;
import com.nbsaas.life.system.api.domain.response.DictItemResponse;
import com.nbsaas.life.system.api.domain.simple.DictItemSimple;


/**
 * 对外接口
 */
public interface DictItemApi extends BaseApi
        <DictItemResponse, DictItemSimple, DictItemDataRequest> {


}
