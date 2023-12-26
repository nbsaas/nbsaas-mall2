package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopRole;
import com.nbsaas.life.shop.api.domain.simple.ShopRoleSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ShopRoleSimpleConvert implements Converter<ShopRoleSimple, ShopRole> {




@Override
public ShopRoleSimple convert(ShopRole source) {
    ShopRoleSimple result = new ShopRoleSimple();

                result.setNote(source.getNote());
                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                result.setName(source.getName());
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                result.setId(source.getId());


    return result;
}

}