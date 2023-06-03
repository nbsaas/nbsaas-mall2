package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.response.MenuResponse;
import com.nbsaas.life.system.data.entity.Menu;

/**
 * 实体对象转化成响应对象
 */

public class MenuResponseConvert implements Converter
        <MenuResponse, Menu> {

    @Override
    public MenuResponse convert(Menu source) {
        MenuResponse result = new MenuResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }
        return result;
    }

}

