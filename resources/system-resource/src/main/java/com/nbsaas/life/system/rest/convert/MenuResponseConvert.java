package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Menu;
import com.nbsaas.life.system.api.domain.response.MenuResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class MenuResponseConvert  implements Converter<MenuResponse,Menu> {

    @Override
    public MenuResponse convert(Menu source) {
        MenuResponse  result = new  MenuResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

