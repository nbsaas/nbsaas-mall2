package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.Shop;
import com.nbsaas.life.shop.api.domain.request.ShopDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.area.data.entity.Area;
import com.nbsaas.life.area.data.entity.Area;
import com.nbsaas.life.user.data.entity.UserInfo;
import com.nbsaas.life.area.data.entity.Area;

/**
* 请求对象转换成实体对象
*/

public class ShopEntityConvert  implements Converter<Shop, ShopDataRequest> {
@Override
public Shop convert(ShopDataRequest source) {
    Shop result = new Shop();
    BeanDataUtils.copyProperties(source, result);
    if (source.getCity() != null) {
        Area city = new Area();
        city.setId(source.getCity());
        result.setCity(city);
    }
    if (source.getProvince() != null) {
        Area province = new Area();
        province.setId(source.getProvince());
        result.setProvince(province);
    }
    if (source.getUser() != null) {
        UserInfo user = new UserInfo();
        user.setId(source.getUser());
        result.setUser(user);
    }
    if (source.getArea() != null) {
        Area area = new Area();
        area.setId(source.getArea());
        result.setArea(area);
    }
    return result;
}
}

