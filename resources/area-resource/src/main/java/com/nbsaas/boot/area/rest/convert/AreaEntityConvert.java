package com.nbsaas.boot.area.rest.convert;

import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.area.api.domain.request.AreaRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.area.data.entity.Area;

/**
* 请求对象转换成实体对象
*/

public class AreaEntityConvert  implements Converter<Area, AreaRequest> {

    @Override
    public Area convert(AreaRequest source) {
        Area result = new Area();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getParent()!=null){
                    Area parent =new Area();
                    parent.setId(source.getParent());
                    result.setParent(parent);
                    }
        return result;
    }
}

