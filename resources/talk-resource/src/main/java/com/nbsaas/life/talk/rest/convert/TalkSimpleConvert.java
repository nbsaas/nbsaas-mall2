package com.nbsaas.life.talk.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.talk.api.domain.simple.TalkSimple;
import com.nbsaas.life.talk.data.entity.Talk;
/**
* 列表对象转换器
*/

public class TalkSimpleConvert implements Converter<TalkSimple, Talk> {




    @Override
    public TalkSimple convert(Talk source) {
        TalkSimple result = new TalkSimple();

        result.setReplies(source.getReplies());
        result.setLastDate(source.getLastDate());
        result.setTopic(source.getTopic());
        result.setId(source.getId());
        result.setMessage(source.getMessage());
        result.setSubscribe(source.getSubscribe());
        result.setLastMessage(source.getLastMessage());
        result.setAddDate(source.getAddDate());


        return result;
    }

}