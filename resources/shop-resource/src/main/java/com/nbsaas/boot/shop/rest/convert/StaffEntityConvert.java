package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.Staff;
import com.nbsaas.boot.shop.api.domain.request.StaffRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class StaffEntityConvert  implements Converter<Staff, StaffRequest> {

    @Override
    public Staff convert(StaffRequest source) {
        Staff result = new Staff();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

