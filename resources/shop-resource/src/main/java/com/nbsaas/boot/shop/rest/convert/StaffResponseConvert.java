package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.Staff;
import com.nbsaas.boot.shop.api.domain.response.StaffResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class StaffResponseConvert  implements Converter<StaffResponse,Staff> {

    @Override
    public StaffResponse convert(Staff source) {
        StaffResponse  result = new  StaffResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

