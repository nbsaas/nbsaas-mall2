package com.nbsaas.boot.shop.rest.resource;

import com.nbsaas.boot.shop.api.apis.StaffApi;
import com.nbsaas.boot.shop.data.entity.Staff;
import com.nbsaas.boot.shop.api.domain.request.StaffRequest;
import com.nbsaas.boot.shop.api.domain.response.StaffResponse;
import com.nbsaas.boot.shop.api.domain.simple.StaffSimple;
import com.nbsaas.boot.shop.rest.convert.StaffSimpleConvert;
import com.nbsaas.boot.shop.rest.convert.StaffEntityConvert;
import com.nbsaas.boot.shop.rest.convert.StaffResponseConvert;
import com.nbsaas.boot.shop.data.repository.StaffRepository;

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
public class StaffResource extends BaseResource<Staff,StaffResponse, StaffSimple, StaffRequest>  implements StaffApi {

    @Resource
    private StaffRepository staffRepository;

    @Override
    public JpaRepositoryImplementation<Staff, Serializable> getJpaRepository() {
        return staffRepository;
    }

    @Override
    public Function<Staff, StaffSimple> getConvertSimple() {
        return new StaffSimpleConvert();
    }

    @Override
    public Function<StaffRequest, Staff> getConvertForm() {
        return new StaffEntityConvert();
    }

    @Override
    public Function<Staff, StaffResponse> getConvertResponse() {
        return new StaffResponseConvert();
    }




}


