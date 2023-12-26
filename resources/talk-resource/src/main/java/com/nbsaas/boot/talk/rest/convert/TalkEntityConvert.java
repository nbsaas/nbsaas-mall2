package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.Talk;
import com.nbsaas.boot.talk.api.domain.request.TalkRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class TalkEntityConvert  implements Converter<Talk, TalkRequest> {

    @Override
    public Talk convert(TalkRequest source) {
        Talk result = new Talk();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

