package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Mock;
import com.nbsaas.life.system.api.domain.simple.MockSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class MockSimpleConvert implements Converter<MockSimple, Mock> {




    @Override
    public MockSimple convert(Mock source) {
        MockSimple result = new MockSimple();

                    result.setLastDate(source.getLastDate());
                    result.setContent(source.getContent());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setName(source.getName());


    return result;
  }

}