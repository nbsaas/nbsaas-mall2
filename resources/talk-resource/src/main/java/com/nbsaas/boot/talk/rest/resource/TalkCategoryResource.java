package com.nbsaas.boot.talk.rest.resource;

import com.nbsaas.boot.talk.api.apis.TalkCategoryApi;
import com.nbsaas.boot.talk.data.entity.TalkCategory;
import com.nbsaas.boot.talk.api.domain.request.TalkCategoryRequest;
import com.nbsaas.boot.talk.api.domain.response.TalkCategoryResponse;
import com.nbsaas.boot.talk.api.domain.simple.TalkCategorySimple;
import com.nbsaas.boot.talk.rest.convert.TalkCategorySimpleConvert;
import com.nbsaas.boot.talk.rest.convert.TalkCategoryEntityConvert;
import com.nbsaas.boot.talk.rest.convert.TalkCategoryResponseConvert;
import com.nbsaas.boot.talk.data.repository.TalkCategoryRepository;

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
public class TalkCategoryResource extends BaseResource<TalkCategory,TalkCategoryResponse, TalkCategorySimple, TalkCategoryRequest>  implements TalkCategoryApi {

    @Resource
    private TalkCategoryRepository talkCategoryRepository;

    @Override
    public JpaRepositoryImplementation<TalkCategory, Serializable> getJpaRepository() {
        return talkCategoryRepository;
    }

    @Override
    public Function<TalkCategory, TalkCategorySimple> getConvertSimple() {
        return new TalkCategorySimpleConvert();
    }

    @Override
    public Function<TalkCategoryRequest, TalkCategory> getConvertForm() {
        return new TalkCategoryEntityConvert();
    }

    @Override
    public Function<TalkCategory, TalkCategoryResponse> getConvertResponse() {
        return new TalkCategoryResponseConvert();
    }




}


