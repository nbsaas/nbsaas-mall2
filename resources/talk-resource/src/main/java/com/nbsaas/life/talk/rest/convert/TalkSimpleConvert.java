package com.nbsaas.life.talk.rest.convert;

import com.nbsaas.life.talk.data.entity.Talk;
import com.nbsaas.life.talk.api.domain.simple.TalkSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class TalkSimpleConvert implements Converter<TalkSimple, Talk> {




    @Override
    public TalkSimple convert(Talk source) {
        TalkSimple result = new TalkSimple();

                    result.setReplies(source.getReplies());
                    result.setLastMessage(source.getLastMessage());
                    result.setLastDate(source.getLastDate());
                    result.setSubscribe(source.getSubscribe());
                    result.setMessage(source.getMessage());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setTopic(source.getTopic());


    return result;
  }

}