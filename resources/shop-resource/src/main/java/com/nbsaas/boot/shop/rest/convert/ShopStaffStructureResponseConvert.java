package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopStaffStructure;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffStructureResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopStaffStructureResponseConvert  implements Converter<ShopStaffStructureResponse,ShopStaffStructure> {

    @Override
    public ShopStaffStructureResponse convert(ShopStaffStructure source) {
        ShopStaffStructureResponse  result = new  ShopStaffStructureResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getParent()!=null){
                        result.setParent(source.getParent().getId());
                    }
                    if(source.getShop()!=null){
                        result.setShop(source.getShop().getId());
                    }
                    if(source.getShop()!=null){
                        result.setShopName(source.getShop().getName());
                    }
                    if(source.getParent()!=null){
                        result.setParentName(source.getParent().getName());
                    }
        return result;
    }

}

