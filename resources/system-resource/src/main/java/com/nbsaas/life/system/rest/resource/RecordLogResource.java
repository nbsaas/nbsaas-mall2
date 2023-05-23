package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.RecordLogApi;
import com.nbsaas.life.system.data.entity.RecordLog;
import com.nbsaas.life.system.api.domain.request.RecordLogDataRequest;
import com.nbsaas.life.system.api.domain.response.RecordLogResponse;
import com.nbsaas.life.system.api.domain.simple.RecordLogSimple;
import com.nbsaas.life.system.rest.convert.RecordLogSimpleConvert;
import com.nbsaas.life.system.rest.convert.RecordLogEntityConvert;
import com.nbsaas.life.system.rest.convert.RecordLogResponseConvert;
import com.nbsaas.life.system.data.repository.RecordLogRepository;

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
public class RecordLogResource extends BaseResource<RecordLog,RecordLogResponse, RecordLogSimple, RecordLogDataRequest>  implements RecordLogApi {

    @Resource
    private RecordLogRepository recordLogRepository;

    @Override
    public JpaRepositoryImplementation<RecordLog, Serializable> getJpaRepository() {
        return recordLogRepository;
    }

    @Override
    public Function<RecordLog, RecordLogSimple> getConvertSimple() {
        return new RecordLogSimpleConvert();
    }

    @Override
    public Function<RecordLogDataRequest, RecordLog> getConvertForm() {
        return new RecordLogEntityConvert();
    }

    @Override
    public Function<RecordLog, RecordLogResponse> getConvertResponse() {
        return new RecordLogResponseConvert();
    }

}


