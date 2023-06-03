package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.response.MockResponse;
import com.nbsaas.life.system.data.entity.Mock;

/**
 * 实体对象转化成响应对象
 */

public class MockResponseConvert implements Converter
        <MockResponse, Mock> {

    @Override
    public MockResponse convert(Mock source) {
        MockResponse result = new MockResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

