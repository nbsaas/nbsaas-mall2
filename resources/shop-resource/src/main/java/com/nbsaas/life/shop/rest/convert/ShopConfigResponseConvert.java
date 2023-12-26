package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopConfig;
import com.nbsaas.life.shop.api.domain.response.ShopConfigResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopConfigResponseConvert  implements Converter<ShopConfigResponse,ShopConfig> {

    @Override
    public ShopConfigResponse convert(ShopConfig source) {
        ShopConfigResponse  result = new  ShopConfigResponse();
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

