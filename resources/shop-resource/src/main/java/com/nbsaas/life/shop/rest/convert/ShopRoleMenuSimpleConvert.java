package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopRoleMenu;
import com.nbsaas.life.shop.api.domain.simple.ShopRoleMenuSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ShopRoleMenuSimpleConvert implements Converter<ShopRoleMenuSimple, ShopRoleMenu> {




@Override
public ShopRoleMenuSimple convert(ShopRoleMenu source) {
    ShopRoleMenuSimple result = new ShopRoleMenuSimple();

                if(source.getRole()!=null){
                    result.setRole(source.getRole().getId());
                }
                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                if(source.getMenu()!=null){
                    result.setPermission(source.getMenu().getPermission());
                }
                result.setId(source.getId());
                if(source.getMenu()!=null){
                    result.setMenu(source.getMenu().getId());
                }
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}