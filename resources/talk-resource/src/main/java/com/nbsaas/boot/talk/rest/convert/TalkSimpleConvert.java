package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.Talk;
import com.nbsaas.boot.talk.api.domain.simple.TalkSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class TalkSimpleConvert implements Converter<TalkSimple, Talk> {




@Override
public TalkSimple convert(Talk source) {
    TalkSimple result = new TalkSimple();

                result.setReplies(source.getReplies());
                result.setSubscribe(source.getSubscribe());
                result.setLastMessage(source.getLastMessage());
                result.setTopic(source.getTopic());
                result.setId(source.getId());
                result.setMessage(source.getMessage());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}