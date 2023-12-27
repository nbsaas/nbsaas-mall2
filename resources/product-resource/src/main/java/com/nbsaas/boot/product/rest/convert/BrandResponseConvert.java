package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.Brand;
import com.nbsaas.boot.product.api.domain.response.BrandResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import java.util.HashMap;
import java.util.Map;
/**
* 实体对象转化成响应对象
*/

public class BrandResponseConvert  implements Converter<BrandResponse,Brand> {

    @Override
    public BrandResponse convert(Brand source) {
        BrandResponse  result = new  BrandResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getStoreState()!=null){
                        result.setStoreStateName(String.valueOf(source.getStoreState()));
                    }
                    if(source.getRecommend()!=null){
                    Map<Integer,String> RecommendMap=new HashMap<>();
                        RecommendMap.put(1,"是");
                        RecommendMap.put(2,"否");
                    String label=  RecommendMap.get(source.getRecommend());
                    result.setRecommendName(label);
                    }
                    result.setRecommend(source.getRecommend());
        return result;
    }

}

