package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopSearchWord;
import com.nbsaas.boot.shop.api.domain.response.ShopSearchWordResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import java.util.HashMap;
import java.util.Map;
/**
* 实体对象转化成响应对象
*/

public class ShopSearchWordResponseConvert  implements Converter<ShopSearchWordResponse,ShopSearchWord> {

    @Override
    public ShopSearchWordResponse convert(ShopSearchWord source) {
        ShopSearchWordResponse  result = new  ShopSearchWordResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                        result.setShop(source.getShop().getId());
                    }
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
        return result;
    }

}

