package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.data.entity.Ad;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class AdSimpleConvert implements Converter<AdSimple, Ad> {




@Override
public AdSimple convert(Ad source) {
    AdSimple result = new AdSimple();

                result.setNote(source.getNote());
                result.setEndDate(source.getEndDate());
                result.setCatalog(source.getCatalog());
                result.setTitle(source.getTitle());
                result.setAddDate(source.getAddDate());
                result.setUrl(source.getUrl());
                result.setBussId(source.getBussId());
                if(source.getAdPosition()!=null){
                    result.setAdPosition(source.getAdPosition().getId());
                }
                result.setPath(source.getPath());
                result.setBeginDate(source.getBeginDate());
                result.setSortNum(source.getSortNum());
                result.setId(source.getId());
                if(source.getAdPosition()!=null){
                    result.setAdPositionName(source.getAdPosition().getName());
                }
                result.setLastDate(source.getLastDate());


    return result;
}

}