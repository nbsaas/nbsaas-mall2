package com.nbsaas.boot.customer.ext.apis;

import com.nbsaas.boot.common.ext.domain.simple.CountSimple;
import com.nbsaas.boot.rest.response.ListResponse;

public interface CustomerCountApi {

    ListResponse<CountSimple> countByRecent12Month();
}
