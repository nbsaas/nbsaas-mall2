package com.nbsaas.boot.area.rest.convert;

import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.area.api.domain.simple.AreaSimple;

import com.nbsaas.boot.rest.api.Converter;
    import java.util.stream.Collectors;
    import lombok.Data;

/**
* 列表对象转换器
*/

    @Data
public class AreaSimpleConvert implements Converter<AreaSimple, Area> {


    private int fetch;


@Override
public AreaSimple convert(Area source) {
    AreaSimple result = new AreaSimple();

                if(source.getParent()!=null){
                    result.setParent(source.getParent().getId());
                }
                result.setCode(source.getCode());
                result.setLng(source.getLng());
                result.setFullName(source.getFullName());
                result.setAddDate(source.getAddDate());
                result.setGovCode(source.getGovCode());
                result.setDepth(source.getDepth());
                result.setAreaType(source.getAreaType());
                result.setName(source.getName());
                result.setIds(source.getIds());
                result.setSortNum(source.getSortNum());
                result.setState(source.getState());
                result.setId(source.getId());
                result.setLft(source.getLft());
                result.setLat(source.getLat());
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