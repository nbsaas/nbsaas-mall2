package com.nbsaas.life.talk.rest.convert;

import com.nbsaas.life.talk.data.entity.Talk;
import com.nbsaas.life.talk.api.domain.response.TalkResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
 * 实体对象转化成响应对象
 */

public class TalkResponseConvert implements Converter
        <TalkResponse, Talk> {

    @Override
    public TalkResponse convert(Talk source) {
        TalkResponse result = new TalkResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

