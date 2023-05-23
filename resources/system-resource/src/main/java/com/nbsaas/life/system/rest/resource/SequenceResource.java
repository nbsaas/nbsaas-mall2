package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.SequenceApi;
import com.nbsaas.life.system.data.entity.Sequence;
import com.nbsaas.life.system.api.domain.request.SequenceDataRequest;
import com.nbsaas.life.system.api.domain.response.SequenceResponse;
import com.nbsaas.life.system.api.domain.simple.SequenceSimple;
import com.nbsaas.life.system.rest.convert.SequenceSimpleConvert;
import com.nbsaas.life.system.rest.convert.SequenceEntityConvert;
import com.nbsaas.life.system.rest.convert.SequenceResponseConvert;
import com.nbsaas.life.system.data.repository.SequenceRepository;

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
public class SequenceResource extends BaseResource<Sequence,SequenceResponse, SequenceSimple, SequenceDataRequest>  implements SequenceApi {

    @Resource
    private SequenceRepository sequenceRepository;

    @Override
    public JpaRepositoryImplementation<Sequence, Serializable> getJpaRepository() {
        return sequenceRepository;
    }

    @Override
    public Function<Sequence, SequenceSimple> getConvertSimple() {
        return new SequenceSimpleConvert();
    }

    @Override
    public Function<SequenceDataRequest, Sequence> getConvertForm() {
        return new SequenceEntityConvert();
    }

    @Override
    public Function<Sequence, SequenceResponse> getConvertResponse() {
        return new SequenceResponseConvert();
    }

}


