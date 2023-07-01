package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.RoleMenu;
import com.nbsaas.life.system.api.domain.request.RoleMenuDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.life.system.data.entity.Role;
            import com.nbsaas.life.system.data.entity.Menu;

/**
* 请求对象转换成实体对象
*/

public class RoleMenuEntityConvert  implements Converter<RoleMenu, RoleMenuDataRequest> {

    @Override
    public RoleMenu convert(RoleMenuDataRequest source) {
        RoleMenu result = new RoleMenu();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getRole()!=null){
                    Role role =new Role();
                    role.setId(source.getRole());
                    result.setRole(role);
                    }
                    if(source.getMenu()!=null){
                    Menu menu =new Menu();
                    menu.setId(source.getMenu());
                    result.setMenu(menu);
                    }
        return result;
    }
}

