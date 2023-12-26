package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkReply;
import com.nbsaas.boot.talk.api.domain.request.TalkReplyRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class TalkReplyEntityConvert  implements Converter<TalkReply, TalkReplyRequest> {

    @Override
    public TalkReply convert(TalkReplyRequest source) {
        TalkReply result = new TalkReply();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

