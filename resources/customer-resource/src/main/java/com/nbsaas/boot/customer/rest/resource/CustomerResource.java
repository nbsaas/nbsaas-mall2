package com.nbsaas.boot.customer.rest.resource;

import com.nbsaas.boot.customer.api.apis.CustomerApi;
import com.nbsaas.boot.customer.data.entity.Customer;
import com.nbsaas.boot.customer.api.domain.request.CustomerRequest;
import com.nbsaas.boot.customer.api.domain.response.CustomerResponse;
import com.nbsaas.boot.customer.api.domain.simple.CustomerSimple;
import com.nbsaas.boot.customer.rest.convert.CustomerSimpleConvert;
import com.nbsaas.boot.customer.rest.convert.CustomerEntityConvert;
import com.nbsaas.boot.customer.rest.convert.CustomerResponseConvert;
import com.nbsaas.boot.customer.data.repository.CustomerRepository;

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
public class CustomerResource extends BaseResource<Customer,CustomerResponse, CustomerSimple, CustomerRequest>  implements CustomerApi {

    @Resource
    private CustomerRepository customerRepository;

    @Override
    public JpaRepositoryImplementation<Customer, Serializable> getJpaRepository() {
        return customerRepository;
    }

    @Override
    public Function<Customer, CustomerSimple> getConvertSimple() {
        return new CustomerSimpleConvert();
    }

    @Override
    public Function<CustomerRequest, Customer> getConvertForm() {
        return new CustomerEntityConvert();
    }

    @Override
    public Function<Customer, CustomerResponse> getConvertResponse() {
    return new CustomerResponseConvert();
    }




}


