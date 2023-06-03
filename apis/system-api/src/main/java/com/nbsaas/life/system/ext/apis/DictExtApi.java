package com.nbsaas.life.system.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.system.api.domain.request.DictDataRequest;
import com.nbsaas.life.system.api.domain.response.DictResponse;

public interface DictExtApi {

    /**
     * 创建字典
     *
     * @param request
     * @return
     */
    ResponseObject<DictResponse> create(DictDataRequest request);
}
