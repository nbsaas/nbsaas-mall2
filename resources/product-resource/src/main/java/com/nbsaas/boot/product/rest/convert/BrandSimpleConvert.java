package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.Brand;
import com.nbsaas.boot.product.api.domain.simple.BrandSimple;

import com.nbsaas.boot.rest.api.Converter;
import java.util.HashMap;
import java.util.Map;

/**
* 列表对象转换器
*/

public class BrandSimpleConvert implements Converter<BrandSimple, Brand> {




@Override
public BrandSimple convert(Brand source) {
    BrandSimple result = new BrandSimple();

                result.setNote(source.getNote());
                result.setName(source.getName());
                result.setLogo(source.getLogo());
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                if(source.getRecommend()!=null){
                   Map<Integer,String> RecommendMap=new HashMap<>();
                       RecommendMap.put(1,"是");
                       RecommendMap.put(2,"否");
                   String label=  RecommendMap.get(source.getRecommend());
                   result.setRecommendName(label);
                }
                result.setRecommend(source.getRecommend());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}