package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopStaff;
import com.nbsaas.life.shop.api.domain.simple.ShopStaffSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ShopStaffSimpleConvert implements Converter<ShopStaffSimple, ShopStaff> {




@Override
public ShopStaffSimple convert(ShopStaff source) {
    ShopStaffSimple result = new ShopStaffSimple();

                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                if(source.getUser()!=null){
                    result.setPhone(source.getUser().getPhone());
                }
                if(source.getUser()!=null){
                    result.setName(source.getUser().getName());
                }
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                result.setId(source.getId());
                if(source.getUser()!=null){
                    result.setAvatar(source.getUser().getAvatar());
                }
                if(source.getUser()!=null){
                    result.setUserName(source.getUser().getName());
                }
                if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                }
                result.setAddDate(source.getAddDate());
                result.setLoginSize(source.getLoginSize());
                result.setLastDate(source.getLastDate());


    return result;
}

}