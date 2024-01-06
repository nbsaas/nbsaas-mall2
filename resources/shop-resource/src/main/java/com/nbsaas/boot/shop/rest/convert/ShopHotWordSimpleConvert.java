package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopHotWord;
import com.nbsaas.boot.shop.api.domain.simple.ShopHotWordSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ShopHotWordSimpleConvert implements Converter<ShopHotWordSimple, ShopHotWord> {




@Override
public ShopHotWordSimple convert(ShopHotWord source) {
    ShopHotWordSimple result = new ShopHotWordSimple();

                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                if(source.getStaff()!=null){
                    result.setStaff(source.getStaff().getId());
                }
                result.setSortNum(source.getSortNum());
                result.setId(source.getId());
                result.setWord(source.getWord());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}