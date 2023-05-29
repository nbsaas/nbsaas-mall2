package com.nbsaas.life.ad.rest.convert;

import com.nbsaas.life.ad.data.entity.Ad;
import com.nbsaas.life.ad.api.domain.simple.AdSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class AdSimpleConvert implements Converter<AdSimple, Ad> {




    @Override
    public AdSimple convert(Ad source) {
        AdSimple result = new AdSimple();

                    result.setUrl(source.getUrl());
                    result.setTitle(source.getTitle());
                    result.setSortNum(source.getSortNum());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setEndDate(source.getEndDate());
                    if(source.getAdPosition()!=null){
                        result.setAdPositionName(source.getAdPosition().getName());
                    }
                    result.setBussId(source.getBussId());
                    result.setBeginDate(source.getBeginDate());
                    result.setPath(source.getPath());
                    result.setLastDate(source.getLastDate());
                    result.setCatalog(source.getCatalog());
                    result.setNote(source.getNote());
                    if(source.getAdPosition()!=null){
                        result.setAdPosition(source.getAdPosition().getId());
                    }


    return result;
  }

}