package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.Shop;
import com.nbsaas.boot.shop.api.domain.response.ShopResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopResponseConvert  implements Converter<ShopResponse,Shop> {

    @Override
    public ShopResponse convert(Shop source) {
        ShopResponse  result = new  ShopResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getCity()!=null){
                        result.setCity(source.getCity().getId());
                    }
                    if(source.getProvince()!=null){
                        result.setProvince(source.getProvince().getId());
                    }
                    if(source.getArea()!=null){
                        result.setArea(source.getArea().getId());
                    }
                    if(source.getStoreState()!=null){
                        result.setStoreStateName(String.valueOf(source.getStoreState()));
                    }
                    if(source.getUser()!=null){
                        result.setUser(source.getUser().getId());
                    }
        return result;
    }

}

