package com.nbsaas.life.talk.api.apis;

import com.nbsaas.life.talk.api.domain.request.TalkDataRequest;
import com.nbsaas.life.talk.api.domain.simple.TalkSimple;
import com.nbsaas.life.talk.api.domain.response.TalkResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface TalkApi extends BaseApi<TalkResponse, TalkSimple, TalkDataRequest> {


}
