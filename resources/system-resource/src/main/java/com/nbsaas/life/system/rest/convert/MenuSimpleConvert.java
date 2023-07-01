package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.Menu;
import com.nbsaas.life.system.api.domain.simple.MenuSimple;

import com.nbsaas.boot.rest.api.Converter;
    import java.util.stream.Collectors;
    import lombok.Data;
/**
* 列表对象转换器
*/

    @Data
public class MenuSimpleConvert implements Converter<MenuSimple, Menu> {


    private int fetch;


@Override
public MenuSimple convert(Menu source) {
    MenuSimple result = new MenuSimple();

                if(source.getParent()!=null){
                    result.setParent(source.getParent().getId());
                }
                result.setCode(source.getCode());
                result.setCatalog(source.getCatalog());
                result.setIcon(source.getIcon());
                result.setPermission(source.getPermission());
                result.setAddDate(source.getAddDate());
                result.setPath(source.getPath());
                result.setRouter(source.getRouter());
                result.setDepth(source.getDepth());
                result.setName(source.getName());
                result.setIds(source.getIds());
                result.setMenuType(source.getMenuType());
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