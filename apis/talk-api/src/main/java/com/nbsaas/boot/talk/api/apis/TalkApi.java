package com.nbsaas.boot.talk.api.apis;

import com.nbsaas.boot.talk.api.domain.request.TalkRequest;
import com.nbsaas.boot.talk.api.domain.simple.TalkSimple;
import com.nbsaas.boot.talk.api.domain.response.TalkResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface TalkApi extends BaseApi<TalkResponse, TalkSimple, TalkRequest> {


}
