package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopTag;
import com.nbsaas.life.shop.api.domain.simple.ShopTagSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ShopTagSimpleConvert implements Converter<ShopTagSimple, ShopTag> {




@Override
public ShopTagSimple convert(ShopTag source) {
    ShopTagSimple result = new ShopTagSimple();

                result.setSize(source.getSize());
                result.setName(source.getName());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}