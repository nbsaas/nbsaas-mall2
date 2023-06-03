package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopCategory;
import com.nbsaas.life.shop.api.domain.simple.ShopCategorySimple;

import com.nbsaas.boot.rest.api.Converter;

/**
 * 列表对象转换器
 */

public class ShopCategorySimpleConvert implements Converter
        <ShopCategorySimple, ShopCategory> {


    @Override
    public ShopCategorySimple convert(ShopCategory source) {
        ShopCategorySimple result = new ShopCategorySimple();

        result.setLastDate(source.getLastDate());
        result.setNums(source.getNums());
        result.setIcon(source.getIcon());
        result.setPinyin(source.getPinyin());
        result.setPath(source.getPath());
        result.setCode(source.getCode());
        result.setLft(source.getLft());
        result.setDepth(source.getDepth());
        result.setAddDate(source.getAddDate());
        result.setPy(source.getPy());
        result.setSortNum(source.getSortNum());
        result.setId(source.getId());
        result.setRgt(source.getRgt());
        result.setName(source.getName());
        result.setIds(source.getIds());
        result.setCname(source.getCname());


        return result;
    }

}