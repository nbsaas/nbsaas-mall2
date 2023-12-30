package com.nbsaas.boot.common.rest.resource;

import com.nbsaas.boot.common.api.apis.SequenceTableApi;
import com.nbsaas.boot.common.data.entity.SequenceTable;
import com.nbsaas.boot.common.api.domain.request.SequenceTableRequest;
import com.nbsaas.boot.common.api.domain.response.SequenceTableResponse;
import com.nbsaas.boot.common.api.domain.simple.SequenceTableSimple;
import com.nbsaas.boot.common.rest.convert.SequenceTableSimpleConvert;
import com.nbsaas.boot.common.rest.convert.SequenceTableEntityConvert;
import com.nbsaas.boot.common.rest.convert.SequenceTableResponseConvert;
import com.nbsaas.boot.common.data.repository.SequenceTableRepository;

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
public class SequenceTableResource extends BaseResource<SequenceTable,SequenceTableResponse, SequenceTableSimple, SequenceTableRequest>  implements SequenceTableApi {

    @Resource
    private SequenceTableRepository sequenceTableRepository;

    @Override
    public JpaRepositoryImplementation<SequenceTable, Serializable> getJpaRepository() {
        return sequenceTableRepository;
    }

    @Override
    public Function<SequenceTable, SequenceTableSimple> getConvertSimple() {
        return new SequenceTableSimpleConvert();
    }

    @Override
    public Function<SequenceTableRequest, SequenceTable> getConvertForm() {
        return new SequenceTableEntityConvert();
    }

    @Override
    public Function<SequenceTable, SequenceTableResponse> getConvertResponse() {
        return new SequenceTableResponseConvert();
    }




}


