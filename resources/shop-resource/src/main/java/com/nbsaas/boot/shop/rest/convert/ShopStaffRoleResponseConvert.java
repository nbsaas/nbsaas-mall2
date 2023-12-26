package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopStaffRole;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffRoleResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopStaffRoleResponseConvert  implements Converter<ShopStaffRoleResponse,ShopStaffRole> {

    @Override
    public ShopStaffRoleResponse convert(ShopStaffRole source) {
        ShopStaffRoleResponse  result = new  ShopStaffRoleResponse();
        BeanDataUtils.copyProperties(source, result);
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
        return result;
    }

}

