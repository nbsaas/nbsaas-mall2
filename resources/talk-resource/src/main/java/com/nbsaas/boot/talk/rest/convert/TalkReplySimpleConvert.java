package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkReply;
import com.nbsaas.boot.talk.api.domain.simple.TalkReplySimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class TalkReplySimpleConvert implements Converter<TalkReplySimple, TalkReply> {




@Override
public TalkReplySimple convert(TalkReply source) {
    TalkReplySimple result = new TalkReplySimple();

                result.setReplies(source.getReplies());
                result.setSubscribe(source.getSubscribe());
                result.setTopic(source.getTopic());
                result.setId(source.getId());
                result.setMessage(source.getMessage());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}