package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.shop.api.domain.simple.ShopTagSimple;
import com.nbsaas.life.shop.data.entity.ShopTag;
/**
* 列表对象转换器
*/

public class ShopTagSimpleConvert implements Converter<ShopTagSimple, ShopTag> {




    @Override
    public ShopTagSimple convert(ShopTag source) {
        ShopTagSimple result = new ShopTagSimple();

                    result.setLastDate(source.getLastDate());
        result.setId(source.getId());
        result.setSize(source.getSize());
        result.setName(source.getName());
        result.setAddDate(source.getAddDate());


    return result;
  }

}