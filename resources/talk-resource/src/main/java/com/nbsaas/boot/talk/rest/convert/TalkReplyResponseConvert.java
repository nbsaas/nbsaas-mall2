package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkReply;
import com.nbsaas.boot.talk.api.domain.response.TalkReplyResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class TalkReplyResponseConvert  implements Converter<TalkReplyResponse,TalkReply> {

    @Override
    public TalkReplyResponse convert(TalkReply source) {
        TalkReplyResponse  result = new  TalkReplyResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

