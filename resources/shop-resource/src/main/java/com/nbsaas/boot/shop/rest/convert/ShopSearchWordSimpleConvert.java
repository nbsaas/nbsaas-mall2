package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopSearchWord;
import com.nbsaas.boot.shop.api.domain.simple.ShopSearchWordSimple;

import com.nbsaas.boot.rest.api.Converter;
import java.util.HashMap;
import java.util.Map;

/**
* 列表对象转换器
*/

public class ShopSearchWordSimpleConvert implements Converter<ShopSearchWordSimple, ShopSearchWord> {




@Override
public ShopSearchWordSimple convert(ShopSearchWord source) {
    ShopSearchWordSimple result = new ShopSearchWordSimple();

                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                result.setSearchNum(source.getSearchNum());
                if(source.getSearchType()!=null){
                   Map<Integer,String> SearchTypeMap=new HashMap<>();
                       SearchTypeMap.put(1,"商品");
                       SearchTypeMap.put(2,"文章");
                   String label=  SearchTypeMap.get(source.getSearchType());
                   result.setSearchTypeName(label);
                }
                result.setSearchType(source.getSearchType());
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