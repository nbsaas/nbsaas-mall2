package com.nbsaas.life.talk.rest.convert;

import com.nbsaas.life.talk.data.entity.Talk;
import com.nbsaas.life.talk.api.domain.request.TalkDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class TalkEntityConvert  implements Converter<Talk, TalkDataRequest> {

    @Override
    public Talk convert(TalkDataRequest source) {
        Talk result = new Talk();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

