package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkCategory;
import com.nbsaas.boot.talk.api.domain.simple.TalkCategorySimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class TalkCategorySimpleConvert implements Converter<TalkCategorySimple, TalkCategory> {




@Override
public TalkCategorySimple convert(TalkCategory source) {
    TalkCategorySimple result = new TalkCategorySimple();

                result.setPath(source.getPath());
                result.setCode(source.getCode());
                result.setDepth(source.getDepth());
                result.setIcon(source.getIcon());
                result.setName(source.getName());
                result.setIds(source.getIds());
                result.setSortNum(source.getSortNum());
                result.setId(source.getId());
                result.setLft(source.getLft());
                result.setAddDate(source.getAddDate());
                result.setRgt(source.getRgt());
                result.setLastDate(source.getLastDate());


    return result;
}

}