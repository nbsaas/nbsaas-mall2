package com.nbsaas.boot.talk.rest.resource;

import com.nbsaas.boot.talk.api.apis.TalkCategoryAreaApi;
import com.nbsaas.boot.talk.data.entity.TalkCategoryArea;
import com.nbsaas.boot.talk.api.domain.request.TalkCategoryAreaRequest;
import com.nbsaas.boot.talk.api.domain.response.TalkCategoryAreaResponse;
import com.nbsaas.boot.talk.api.domain.simple.TalkCategoryAreaSimple;
import com.nbsaas.boot.talk.rest.convert.TalkCategoryAreaSimpleConvert;
import com.nbsaas.boot.talk.rest.convert.TalkCategoryAreaEntityConvert;
import com.nbsaas.boot.talk.rest.convert.TalkCategoryAreaResponseConvert;
import com.nbsaas.boot.talk.data.repository.TalkCategoryAreaRepository;

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
public class TalkCategoryAreaResource extends BaseResource<TalkCategoryArea,TalkCategoryAreaResponse, TalkCategoryAreaSimple, TalkCategoryAreaRequest>  implements TalkCategoryAreaApi {

    @Resource
    private TalkCategoryAreaRepository talkCategoryAreaRepository;

    @Override
    public JpaRepositoryImplementation<TalkCategoryArea, Serializable> getJpaRepository() {
        return talkCategoryAreaRepository;
    }

    @Override
    public Function<TalkCategoryArea, TalkCategoryAreaSimple> getConvertSimple() {
        return new TalkCategoryAreaSimpleConvert();
    }

    @Override
    public Function<TalkCategoryAreaRequest, TalkCategoryArea> getConvertForm() {
        return new TalkCategoryAreaEntityConvert();
    }

    @Override
    public Function<TalkCategoryArea, TalkCategoryAreaResponse> getConvertResponse() {
        return new TalkCategoryAreaResponseConvert();
    }




}


