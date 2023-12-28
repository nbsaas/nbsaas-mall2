package com.nbsaas.boot.talk.rest.resource;

import com.nbsaas.boot.talk.api.apis.TalkApi;
import com.nbsaas.boot.talk.data.entity.Talk;
import com.nbsaas.boot.talk.api.domain.request.TalkRequest;
import com.nbsaas.boot.talk.api.domain.response.TalkResponse;
import com.nbsaas.boot.talk.api.domain.simple.TalkSimple;
import com.nbsaas.boot.talk.rest.convert.TalkSimpleConvert;
import com.nbsaas.boot.talk.rest.convert.TalkEntityConvert;
import com.nbsaas.boot.talk.rest.convert.TalkResponseConvert;
import com.nbsaas.boot.talk.data.repository.TalkRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
/**
*   业务接口实现
*/
@Transactional
@Service
public class TalkResource extends BaseResource<Talk,TalkResponse, TalkSimple, TalkRequest>  implements TalkApi {

    @Resource
    private TalkRepository talkRepository;

    @Override
    public JpaRepositoryImplementation<Talk, Serializable> getJpaRepository() {
        return talkRepository;
    }

    @Override
    public Function<Talk, TalkSimple> getConvertSimple() {
        return new TalkSimpleConvert();
    }

    @Override
    public Function<TalkRequest, Talk> getConvertForm() {
        return new TalkEntityConvert();
    }

    @Override
    public Function<Talk, TalkResponse> getConvertResponse() {
        return new TalkResponseConvert();
    }




}


