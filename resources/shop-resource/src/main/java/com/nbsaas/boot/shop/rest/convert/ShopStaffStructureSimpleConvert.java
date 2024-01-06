package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopStaffStructure;
import com.nbsaas.boot.shop.api.domain.simple.ShopStaffStructureSimple;

import com.nbsaas.boot.rest.api.Converter;
    import java.util.stream.Collectors;
    import lombok.Data;

/**
* 列表对象转换器
*/

    @Data
public class ShopStaffStructureSimpleConvert implements Converter<ShopStaffStructureSimple, ShopStaffStructure> {


    private int fetch;


@Override
public ShopStaffStructureSimple convert(ShopStaffStructure source) {
    ShopStaffStructureSimple result = new ShopStaffStructureSimple();

                if(source.getParent()!=null){
                    result.setParent(source.getParent().getId());
                }
                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                result.setCode(source.getCode());
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                result.setAddDate(source.getAddDate());
                if(source.getParent()!=null){
                    result.setParentName(source.getParent().getName());
                }
                result.setDepth(source.getDepth());
                result.setName(source.getName());
                result.setIds(source.getIds());
                result.setSortNum(source.getSortNum());
                result.setId(source.getId());
                result.setLft(source.getLft());
                result.setRgt(source.getRgt());
                result.setLastDate(source.getLastDate());

        result.setLabel(source.getName());
        result.setValue(""+source.getId());
        if (source.getChildren()!=null&&source.getChildren().size()>0){
            if (fetch!=0){
                result.setChildren(source.getChildren().stream().map(this).collect(Collectors.toList()));
            }
        }else{
        }

    return result;
}

}