package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopStaff;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopStaffResponseConvert  implements Converter<ShopStaffResponse,ShopStaff> {

    @Override
    public ShopStaffResponse convert(ShopStaff source) {
        ShopStaffResponse  result = new  ShopStaffResponse();
        BeanDataUtils.copyProperties(source, result);
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
                    if(source.getUser()!=null){
                    result.setAvatar(source.getUser().getAvatar());
                    }
                    if(source.getUser()!=null){
                        result.setUserName(source.getUser().getName());
                    }
                    if(source.getUser()!=null){
                        result.setUser(source.getUser().getId());
                    }
        return result;
    }

}

