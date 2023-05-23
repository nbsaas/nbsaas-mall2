package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopCategory;
import com.nbsaas.life.shop.api.domain.simple.ShopCategorySimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ShopCategorySimpleConvert implements Converter<ShopCategorySimple, ShopCategory> {




    @Override
    public ShopCategorySimple convert(ShopCategory source) {
        ShopCategorySimple result = new ShopCategorySimple();

                    result.setPy(source.getPy());
                    result.setRgt(source.getRgt());
                    result.setSortNum(source.getSortNum());
                    result.setCname(source.getCname());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setDepth(source.getDepth());
                    result.setCode(source.getCode());
                    result.setNums(source.getNums());
                    result.setPinyin(source.getPinyin());
                    result.setIds(source.getIds());
                    result.setPath(source.getPath());
                    result.setLastDate(source.getLastDate());
                    result.setIcon(source.getIcon());
                    result.setLft(source.getLft());
                    result.setName(source.getName());


    return result;
  }

}