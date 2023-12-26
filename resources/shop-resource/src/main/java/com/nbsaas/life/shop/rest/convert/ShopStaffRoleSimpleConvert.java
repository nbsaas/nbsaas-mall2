package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopStaffRole;
import com.nbsaas.life.shop.api.domain.simple.ShopStaffRoleSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ShopStaffRoleSimpleConvert implements Converter<ShopStaffRoleSimple, ShopStaffRole> {




@Override
public ShopStaffRoleSimple convert(ShopStaffRole source) {
    ShopStaffRoleSimple result = new ShopStaffRoleSimple();

                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                if(source.getShopRole()!=null){
                    result.setShopRoleName(source.getShopRole().getName());
                }
                if(source.getShopRole()!=null){
                    result.setShopRole(source.getShopRole().getId());
                }
                if(source.getShopStaff()!=null){
                    result.setShopStaff(source.getShopStaff().getId());
                }
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                result.setId(source.getId());


    return result;
}

}