package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.Shop;
import com.nbsaas.boot.shop.api.domain.request.ShopRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.area.data.entity.Area;
            import com.nbsaas.boot.area.data.entity.Area;
            import com.nbsaas.boot.area.data.entity.Area;
            import com.nbsaas.boot.user.data.entity.UserInfo;

/**
* 请求对象转换成实体对象
*/

public class ShopEntityConvert  implements Converter<Shop, ShopRequest> {

    @Override
    public Shop convert(ShopRequest source) {
        Shop result = new Shop();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getCity()!=null){
                    Area city =new Area();
                    city.setId(source.getCity());
                    result.setCity(city);
                    }
                    if(source.getProvince()!=null){
                    Area province =new Area();
                    province.setId(source.getProvince());
                    result.setProvince(province);
                    }
                    if(source.getArea()!=null){
                    Area area =new Area();
                    area.setId(source.getArea());
                    result.setArea(area);
                    }
                    if(source.getUser()!=null){
                    UserInfo user =new UserInfo();
                    user.setId(source.getUser());
                    result.setUser(user);
                    }
        return result;
    }
}

