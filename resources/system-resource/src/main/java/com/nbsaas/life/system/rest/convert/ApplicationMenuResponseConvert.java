package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.ApplicationMenu;
import com.nbsaas.life.system.api.domain.response.ApplicationMenuResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class ApplicationMenuResponseConvert  implements Converter<ApplicationMenuResponse,ApplicationMenu> {

    @Override
    public ApplicationMenuResponse convert(ApplicationMenu source) {
        ApplicationMenuResponse  result = new  ApplicationMenuResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getApp()!=null){
                    result.setAppName(source.getApp().getName());
                    }
                    if(source.getApp()!=null){
                    result.setApp(source.getApp().getId());
                    }
        return result;
    }

}

