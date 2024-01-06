package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopStaff;
import com.nbsaas.boot.shop.api.domain.simple.ShopStaffSimple;

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
                if(source.getStaff()!=null){
                    result.setPhone(source.getStaff().getPhone());
                }
                if(source.getStaff()!=null){
                    result.setStaffName(source.getStaff().getName());
                }
                if(source.getStaff()!=null){
                    result.setName(source.getStaff().getName());
                }
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                if(source.getStaff()!=null){
                    result.setStaff(source.getStaff().getId());
                }
                result.setId(source.getId());
                if(source.getStaff()!=null){
                    result.setAvatar(source.getStaff().getAvatar());
                }
                result.setAddDate(source.getAddDate());
                result.setLoginSize(source.getLoginSize());
                result.setLastDate(source.getLastDate());


    return result;
}

}