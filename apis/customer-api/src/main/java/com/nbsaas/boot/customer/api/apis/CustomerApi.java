package com.nbsaas.boot.customer.api.apis;

import com.nbsaas.boot.customer.api.domain.request.CustomerRequest;
import com.nbsaas.boot.customer.api.domain.simple.CustomerSimple;
import com.nbsaas.boot.customer.api.domain.response.CustomerResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface CustomerApi extends BaseApi<CustomerResponse, CustomerSimple, CustomerRequest> {


}
