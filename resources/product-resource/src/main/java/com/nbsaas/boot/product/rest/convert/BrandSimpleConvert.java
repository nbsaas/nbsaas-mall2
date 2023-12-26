package com.nbsaas.boot.product.rest.convert;

import com.nbsaas.boot.product.data.entity.Brand;
import com.nbsaas.boot.product.api.domain.simple.BrandSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class BrandSimpleConvert implements Converter<BrandSimple, Brand> {




@Override
public BrandSimple convert(Brand source) {
    BrandSimple result = new BrandSimple();

                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}