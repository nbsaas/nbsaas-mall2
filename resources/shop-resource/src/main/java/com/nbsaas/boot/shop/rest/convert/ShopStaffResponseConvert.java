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
                    if(source.getStaff()!=null){
                    result.setAvatar(source.getStaff().getAvatar());
                    }
        return result;
    }

}

