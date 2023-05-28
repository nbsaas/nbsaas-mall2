package com.nbsaas.life.system.rest.convert;

import com.nbsaas.life.system.data.entity.ApplicationMenu;
import com.nbsaas.life.system.api.domain.simple.ApplicationMenuSimple;

import com.nbsaas.boot.rest.api.Converter;
import java.util.stream.Collectors;
import lombok.Data;
/**
* 列表对象转换器
*/

@Data
public class ApplicationMenuSimpleConvert implements Converter<ApplicationMenuSimple, ApplicationMenu> {


        private int fetch;


    @Override
    public ApplicationMenuSimple convert(ApplicationMenu source) {
        ApplicationMenuSimple result = new ApplicationMenuSimple();

                    result.setRouter(source.getRouter());
                    result.setRgt(source.getRgt());
                    if(source.getApp()!=null){
                        result.setAppName(source.getApp().getName());
                    }
                    result.setSortNum(source.getSortNum());
                    result.setCreator(source.getCreator());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setDepth(source.getDepth());
                    result.setCode(source.getCode());
                    result.setMenuType(source.getMenuType());
                    result.setIds(source.getIds());
                    result.setPath(source.getPath());
                    result.setPermission(source.getPermission());
                    result.setLastDate(source.getLastDate());
                    result.setCatalog(source.getCatalog());
                    result.setIcon(source.getIcon());
                    result.setNum(source.getNum());
                    if(source.getApp()!=null){
                        result.setApp(source.getApp().getId());
                    }
                    result.setLft(source.getLft());
                    result.setName(source.getName());

            result.setLabel(source.getName());
            result.setValue(""+source.getId());
            if (source.getChildren()!=null&&source.getChildren().size()>0){
                if (fetch!=0){
                    result.setChildren(source.getChildren().stream().map(this).collect(Collectors.toList()));
                }
            }

    return result;
  }

}