package com.nbsaas.boot.area.rest.convert;

import com.nbsaas.boot.area.data.entity.AreaHot;
import com.nbsaas.boot.area.api.domain.request.AreaHotRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.area.data.entity.Area;

/**
* 请求对象转换成实体对象
*/

public class AreaHotEntityConvert  implements Converter<AreaHot, AreaHotRequest> {

    @Override
    public AreaHot convert(AreaHotRequest source) {
        AreaHot result = new AreaHot();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getArea()!=null){
                    Area area =new Area();
                    area.setId(source.getArea());
                    result.setArea(area);
                    }
        return result;
    }
}

