package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Application;
import com.nbsaas.life.system.api.domain.request.ApplicationDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ApplicationEntityConvert  implements Converter<Application, ApplicationDataRequest> {

    @Override
    public Application convert(ApplicationDataRequest source) {
        Application result = new Application();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

