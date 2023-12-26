package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopRoleMenu;
import com.nbsaas.life.shop.api.domain.response.ShopRoleMenuResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopRoleMenuResponseConvert  implements Converter<ShopRoleMenuResponse,ShopRoleMenu> {

    @Override
    public ShopRoleMenuResponse convert(ShopRoleMenu source) {
        ShopRoleMenuResponse  result = new  ShopRoleMenuResponse();
        BeanDataUtils.copyProperties(source, result);
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
                    if(source.getMenu()!=null){
                        result.setMenu(source.getMenu().getId());
                    }
        return result;
    }

}

