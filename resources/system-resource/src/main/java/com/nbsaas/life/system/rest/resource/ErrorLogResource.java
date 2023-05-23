package com.nbsaas.life.system.rest.resource;

import com.nbsaas.life.system.api.apis.ErrorLogApi;
import com.nbsaas.life.system.data.entity.ErrorLog;
import com.nbsaas.life.system.api.domain.request.ErrorLogDataRequest;
import com.nbsaas.life.system.api.domain.response.ErrorLogResponse;
import com.nbsaas.life.system.api.domain.simple.ErrorLogSimple;
import com.nbsaas.life.system.rest.convert.ErrorLogSimpleConvert;
import com.nbsaas.life.system.rest.convert.ErrorLogEntityConvert;
import com.nbsaas.life.system.rest.convert.ErrorLogResponseConvert;
import com.nbsaas.life.system.data.repository.ErrorLogRepository;

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
public class ErrorLogResource extends BaseResource<ErrorLog,ErrorLogResponse, ErrorLogSimple, ErrorLogDataRequest>  implements ErrorLogApi {

    @Resource
    private ErrorLogRepository errorLogRepository;

    @Override
    public JpaRepositoryImplementation<ErrorLog, Serializable> getJpaRepository() {
        return errorLogRepository;
    }

    @Override
    public Function<ErrorLog, ErrorLogSimple> getConvertSimple() {
        return new ErrorLogSimpleConvert();
    }

    @Override
    public Function<ErrorLogDataRequest, ErrorLog> getConvertForm() {
        return new ErrorLogEntityConvert();
    }

    @Override
    public Function<ErrorLog, ErrorLogResponse> getConvertResponse() {
        return new ErrorLogResponseConvert();
    }

}


