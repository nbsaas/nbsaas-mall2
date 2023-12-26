package com.nbsaas.boot.talk.rest.convert;

import com.nbsaas.boot.talk.data.entity.TalkCategoryArea;
import com.nbsaas.boot.talk.api.domain.request.TalkCategoryAreaRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class TalkCategoryAreaEntityConvert  implements Converter<TalkCategoryArea, TalkCategoryAreaRequest> {

    @Override
    public TalkCategoryArea convert(TalkCategoryAreaRequest source) {
        TalkCategoryArea result = new TalkCategoryArea();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

