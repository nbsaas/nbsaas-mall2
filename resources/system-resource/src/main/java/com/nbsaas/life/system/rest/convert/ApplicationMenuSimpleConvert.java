package com.nbsaas.life.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.system.api.domain.simple.ApplicationMenuSimple;
import com.nbsaas.life.system.data.entity.ApplicationMenu;
import lombok.Data;

import java.util.stream.Collectors;

/**
 * 列表对象转换器
 */

@Data
public class ApplicationMenuSimpleConvert implements Converter
        <ApplicationMenuSimple, ApplicationMenu> {


    private int fetch;


    @Override
    public ApplicationMenuSimple convert(ApplicationMenu source) {
        ApplicationMenuSimple result = new ApplicationMenuSimple();

        result.setLastDate(source.getLastDate());
        result.setCode(source.getCode());
        result.setLft(source.getLft());
        result.setDepth(source.getDepth());
        result.setRouter(source.getRouter());
        result.setCatalog(source.getCatalog());
        result.setNum(source.getNum());
        result.setIcon(source.getIcon());
        if (source.getApp() != null) {
            result.setAppName(source.getApp().getName());
        }
        result.setAddDate(source.getAddDate());
        result.setSortNum(source.getSortNum());
        if (source.getApp() != null) {
            result.setApp(source.getApp().getId());
        }
        result.setId(source.getId());
        result.setMenuType(source.getMenuType());
        result.setRgt(source.getRgt());
        result.setCreator(source.getCreator());
        result.setName(source.getName());
        result.setPermission(source.getPermission());
        result.setPath(source.getPath());
        result.setIds(source.getIds());

        result.setLabel(source.getName());
        result.setValue("" + source.getId());
        if (source.getChildren() != null && source.getChildren().size() > 0) {
            if (fetch != 0) {
                result.setChildren(source.getChildren().stream().map(this).collect(Collectors.toList()));
            }
        }

        return result;
    }

}