package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkCategoryArea;
import com.nbsaas.boot.talk.api.domain.simple.TalkCategoryAreaSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class TalkCategoryAreaSimpleConvert implements Converter<TalkCategoryAreaSimple, TalkCategoryArea> {




@Override
public TalkCategoryAreaSimple convert(TalkCategoryArea source) {
    TalkCategoryAreaSimple result = new TalkCategoryAreaSimple();

                result.setSize(source.getSize());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}