package com.nbsaas.boot.customer.rest.convert;

import com.nbsaas.boot.customer.data.entity.Customer;
import com.nbsaas.boot.customer.api.domain.request.CustomerRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class CustomerEntityConvert  implements Converter<Customer, CustomerRequest> {

    @Override
    public Customer convert(CustomerRequest source) {
        Customer result = new Customer();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

