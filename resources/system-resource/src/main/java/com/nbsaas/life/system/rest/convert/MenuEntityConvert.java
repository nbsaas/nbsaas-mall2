package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.life.system.api.domain.request.MenuDataRequest;
import com.nbsaas.life.system.data.entity.Menu;

/**
* 请求对象转换成实体对象
*/

public class MenuEntityConvert  implements Converter<Menu, MenuDataRequest> {
@Override
public Menu convert(MenuDataRequest source) {
Menu result = new Menu();
BeanDataUtils.copyProperties(source, result);
            if(source.getParent()!=null){
                Menu parent = new Menu();
                parent.setId(source.getParent());
                result.setParent(parent);
            }
return result;
}
}

