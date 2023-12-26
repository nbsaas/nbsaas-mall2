package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkCategory;
import com.nbsaas.boot.talk.api.domain.response.TalkCategoryResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class TalkCategoryResponseConvert  implements Converter<TalkCategoryResponse,TalkCategory> {

    @Override
    public TalkCategoryResponse convert(TalkCategory source) {
        TalkCategoryResponse  result = new  TalkCategoryResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

