package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkCategoryArea;
import com.nbsaas.boot.talk.api.domain.response.TalkCategoryAreaResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class TalkCategoryAreaResponseConvert  implements Converter<TalkCategoryAreaResponse,TalkCategoryArea> {

    @Override
    public TalkCategoryAreaResponse convert(TalkCategoryArea source) {
        TalkCategoryAreaResponse  result = new  TalkCategoryAreaResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

