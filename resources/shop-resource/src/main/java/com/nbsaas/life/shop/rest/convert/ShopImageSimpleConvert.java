package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopImage;
import com.nbsaas.life.shop.api.domain.simple.ShopImageSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ShopImageSimpleConvert implements Converter<ShopImageSimple, ShopImage> {




@Override
public ShopImageSimple convert(ShopImage source) {
    ShopImageSimple result = new ShopImageSimple();

                result.setNum(source.getNum());
                result.setMessages(source.getMessages());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setUrl(source.getUrl());
                result.setLastDate(source.getLastDate());


    return result;
}

}