package com.nbsaas.life.talk.rest.resource;

import com.nbsaas.life.talk.api.apis.TalkApi;
import com.nbsaas.life.talk.data.entity.Talk;
import com.nbsaas.life.talk.api.domain.request.TalkDataRequest;
import com.nbsaas.life.talk.api.domain.response.TalkResponse;
import com.nbsaas.life.talk.api.domain.simple.TalkSimple;
import com.nbsaas.life.talk.rest.convert.TalkSimpleConvert;
import com.nbsaas.life.talk.rest.convert.TalkEntityConvert;
import com.nbsaas.life.talk.rest.convert.TalkResponseConvert;
import com.nbsaas.life.talk.data.repository.TalkRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class TalkResource extends BaseResource<Talk,TalkResponse, TalkSimple, TalkDataRequest>  implements TalkApi {

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
    public Function<TalkDataRequest, Talk> getConvertForm() {
        return new TalkEntityConvert();
    }

    @Override
    public Function<Talk, TalkResponse> getConvertResponse() {
        return new TalkResponseConvert();
    }

}


