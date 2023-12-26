package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopRole;
import com.nbsaas.boot.shop.api.domain.response.ShopRoleResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopRoleResponseConvert  implements Converter<ShopRoleResponse,ShopRole> {

    @Override
    public ShopRoleResponse convert(ShopRole source) {
        ShopRoleResponse  result = new  ShopRoleResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                        result.setShop(source.getShop().getId());
                    }
                    if(source.getShop()!=null){
                        result.setShopName(source.getShop().getName());
                    }
        return result;
    }

}

