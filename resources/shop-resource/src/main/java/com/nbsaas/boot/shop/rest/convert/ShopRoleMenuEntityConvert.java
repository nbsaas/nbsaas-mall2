package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopRoleMenu;
import com.nbsaas.boot.shop.api.domain.request.ShopRoleMenuRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.shop.data.entity.ShopRole;
            import com.nbsaas.boot.shop.data.entity.Shop;
            import com.nbsaas.boot.app.data.entity.AppMenu;

/**
* 请求对象转换成实体对象
*/

public class ShopRoleMenuEntityConvert  implements Converter<ShopRoleMenu, ShopRoleMenuRequest> {

    @Override
    public ShopRoleMenu convert(ShopRoleMenuRequest source) {
        ShopRoleMenu result = new ShopRoleMenu();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getRole()!=null){
                    ShopRole role =new ShopRole();
                    role.setId(source.getRole());
                    result.setRole(role);
                    }
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
                    if(source.getMenu()!=null){
                    AppMenu menu =new AppMenu();
                    menu.setId(source.getMenu());
                    result.setMenu(menu);
                    }
        return result;
    }
}

