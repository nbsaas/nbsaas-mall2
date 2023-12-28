package com.nbsaas.boot.area.rest.resource;

import com.nbsaas.boot.area.api.apis.AreaApi;
import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.area.api.domain.request.AreaRequest;
import com.nbsaas.boot.area.api.domain.response.AreaResponse;
import com.nbsaas.boot.area.api.domain.simple.AreaSimple;
import com.nbsaas.boot.area.rest.convert.AreaSimpleConvert;
import com.nbsaas.boot.area.rest.convert.AreaEntityConvert;
import com.nbsaas.boot.area.rest.convert.AreaResponseConvert;
import com.nbsaas.boot.area.data.repository.AreaRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.area.api.domain.request.AreaSearch;
/**
*   业务接口实现
*/
@Transactional
@Service
public class AreaResource extends BaseResource<Area,AreaResponse, AreaSimple, AreaRequest>  implements AreaApi {

    @Resource
    private AreaRepository areaRepository;

    @Override
    public JpaRepositoryImplementation<Area, Serializable> getJpaRepository() {
        return areaRepository;
    }

    @Override
    public Function<Area, AreaSimple> getConvertSimple() {
        return new AreaSimpleConvert();
    }

    @Override
    public Function<AreaRequest, Area> getConvertForm() {
        return new AreaEntityConvert();
    }

    @Override
    public Function<Area, AreaResponse> getConvertResponse() {
        return new AreaResponseConvert();
    }



    @Override
    public ListResponse<AreaSimple> list(PageRequest request) {
        AreaSimpleConvert convert=new AreaSimpleConvert();
        if (request instanceof AreaSearch){
             AreaSearch searchRequest=(AreaSearch)request;
             convert.setFetch(searchRequest.getFetch());
        }
        return listSimple(request,convert);
    }

}


