package com.nbsaas.life.ad.rest.convert;

import com.nbsaas.life.ad.data.entity.AdPosition;
import com.nbsaas.life.ad.api.domain.request.AdPositionDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class AdPositionEntityConvert  implements Converter<AdPosition, AdPositionDataRequest> {
@Override
public AdPosition convert(AdPositionDataRequest source) {
AdPosition result = new AdPosition();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

