package com.nbsaas.life.system.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 编码
            **/
            @Search(name = "code",operator = Operator.like)
            private String code;

            /**
            * 菜单类型
            **/
            @Search(name = "catalog",operator = Operator.eq)
            private Integer catalog;

            /**
            * 
            **/
            @Search(name = "icon",operator = Operator.like)
            private String icon;

            /**
            * 
            **/
            @Search(name = "permission",operator = Operator.like)
            private String permission;

            /**
            * 
            **/
            @Search(name = "path",operator = Operator.like)
            private String path;

            /**
            * 
            **/
            @Search(name = "router",operator = Operator.like)
            private String router;

            /**
            * 深度
            **/
            @Search(name = "depth",operator = Operator.eq)
            private Integer depth;

            /**
            * 名称
            **/
            @Search(name = "name",operator = Operator.like)
            private String name;

            /**
            * ids
            **/
            @Search(name = "ids",operator = Operator.like)
            private String ids;

            /**
            * 是否租户使用
            **/
            @Search(name = "menuType",operator = Operator.eq)
            private Integer menuType;

            /**
            * 排序号
            **/
            @Search(name = "sortNum",operator = Operator.eq)
            private Integer sortNum;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 左节点
            **/
            @Search(name = "lft",operator = Operator.eq)
            private Integer lft;

            /**
            * 
            **/
            @Search(name = "nums",operator = Operator.eq)
            private Long nums;

            /**
            * 右节点
            **/
            @Search(name = "rgt",operator = Operator.eq)
            private Integer rgt;


    private int fetch;

}