package com.nbsaas.boot.customer.ext.resource;

import com.nbsaas.boot.common.ext.domain.simple.CountSimple;
import com.nbsaas.boot.customer.data.mapper.CustomerMapper;
import com.nbsaas.boot.customer.ext.apis.CustomerCountApi;
import com.nbsaas.boot.rest.response.ListResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CustomerCountResource implements CustomerCountApi {

    @Resource
    private CustomerMapper customerMapper;

    @Transactional(readOnly = true)
    @Override
    public ListResponse<CountSimple> countByRecent12Month() {
        ListResponse<CountSimple> result = new ListResponse<>();
        result.setData(customerMapper.countByRecent12Month());
        return result;
    }
}
