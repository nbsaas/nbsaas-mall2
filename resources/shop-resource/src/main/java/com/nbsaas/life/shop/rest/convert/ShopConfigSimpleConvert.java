package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopConfig;
import com.nbsaas.life.shop.api.domain.simple.ShopConfigSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ShopConfigSimpleConvert implements Converter<ShopConfigSimple, ShopConfig> {




@Override
public ShopConfigSimple convert(ShopConfig source) {
    ShopConfigSimple result = new ShopConfigSimple();

                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                result.setConfigData(source.getConfigData());
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                result.setClassName(source.getClassName());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}