package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.MockSimple;
import com.nbsaas.life.system.data.entity.Mock;

/**
 * 列表对象转换器
 */

public class MockSimpleConvert implements Converter
        <MockSimple, Mock> {


    @Override
    public MockSimple convert(Mock source) {
        MockSimple result = new MockSimple();

        result.setLastDate(source.getLastDate());
        result.setName(source.getName());
        result.setId(source.getId());
        result.setContent(source.getContent());
        result.setAddDate(source.getAddDate());


        return result;
    }

}