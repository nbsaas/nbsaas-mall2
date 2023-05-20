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
                    result.setLastDate(source.getLastDate());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setName(source.getName());


    return result;
  }

}