package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkCategory;
import com.nbsaas.boot.talk.api.domain.request.TalkCategoryRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class TalkCategoryEntityConvert  implements Converter<TalkCategory, TalkCategoryRequest> {

    @Override
    public TalkCategory convert(TalkCategoryRequest source) {
        TalkCategory result = new TalkCategory();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

