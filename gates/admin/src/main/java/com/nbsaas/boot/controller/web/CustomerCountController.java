package com.nbsaas.boot.controller.web;

import com.nbsaas.boot.common.ext.domain.simple.CountSimple;
import com.nbsaas.boot.customer.ext.apis.CustomerCountApi;
import com.nbsaas.boot.rest.response.ListResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customerCount")
public class CustomerCountController {

    @RequestMapping("/countByRecent12Month")
    public ListResponse<CountSimple> countByRecent12Month() {
        return customerCountApi.countByRecent12Month();
    }

    @RequestMapping("/countByYear")
    public ListResponse<CountSimple> countByYear(Integer year) {
        return customerCountApi.countByYear(year);
    }

    @Resource
    private CustomerCountApi customerCountApi;
}
