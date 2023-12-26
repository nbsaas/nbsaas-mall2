package com.nbsaas.boot.talk.rest.resource;

import com.nbsaas.boot.talk.api.apis.TalkReplyApi;
import com.nbsaas.boot.talk.data.entity.TalkReply;
import com.nbsaas.boot.talk.api.domain.request.TalkReplyRequest;
import com.nbsaas.boot.talk.api.domain.response.TalkReplyResponse;
import com.nbsaas.boot.talk.api.domain.simple.TalkReplySimple;
import com.nbsaas.boot.talk.rest.convert.TalkReplySimpleConvert;
import com.nbsaas.boot.talk.rest.convert.TalkReplyEntityConvert;
import com.nbsaas.boot.talk.rest.convert.TalkReplyResponseConvert;
import com.nbsaas.boot.talk.data.repository.TalkReplyRepository;

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
public class TalkReplyResource extends BaseResource<TalkReply,TalkReplyResponse, TalkReplySimple, TalkReplyRequest>  implements TalkReplyApi {

    @Resource
    private TalkReplyRepository talkReplyRepository;

    @Override
    public JpaRepositoryImplementation<TalkReply, Serializable> getJpaRepository() {
        return talkReplyRepository;
    }

    @Override
    public Function<TalkReply, TalkReplySimple> getConvertSimple() {
        return new TalkReplySimpleConvert();
    }

    @Override
    public Function<TalkReplyRequest, TalkReply> getConvertForm() {
        return new TalkReplyEntityConvert();
    }

    @Override
    public Function<TalkReply, TalkReplyResponse> getConvertResponse() {
    return new TalkReplyResponseConvert();
    }




}


