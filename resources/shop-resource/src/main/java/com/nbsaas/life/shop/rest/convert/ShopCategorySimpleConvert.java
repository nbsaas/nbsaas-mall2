package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopCategory;
import com.nbsaas.life.shop.api.domain.simple.ShopCategorySimple;

import com.nbsaas.boot.rest.api.Converter;
    import java.util.stream.Collectors;
    import lombok.Data;
/**
* 列表对象转换器
*/

    @Data
public class ShopCategorySimpleConvert implements Converter<ShopCategorySimple, ShopCategory> {


    private int fetch;


@Override
public ShopCategorySimple convert(ShopCategory source) {
    ShopCategorySimple result = new ShopCategorySimple();

                result.setCode(source.getCode());
                result.setCname(source.getCname());
                result.setIcon(source.getIcon());
                result.setPy(source.getPy());
                result.setAddDate(source.getAddDate());
                result.setPath(source.getPath());
                result.setPinyin(source.getPinyin());
                result.setDepth(source.getDepth());
                result.setName(source.getName());
                result.setIds(source.getIds());
                result.setSortNum(source.getSortNum());
                result.setId(source.getId());
                result.setLft(source.getLft());
                result.setNums(source.getNums());
                result.setRgt(source.getRgt());
                result.setLastDate(source.getLastDate());

        result.setLabel(source.getName());
        result.setValue(""+source.getId());
        if (source.getChildren()!=null&&source.getChildren().size()>0){
            if (fetch!=0){
                result.setChildren(source.getChildren().stream().map(this).collect(Collectors.toList()));
            }
            result.setHasChildren(true);
        }else{
            result.setHasChildren(false);
        }

    return result;
}

}