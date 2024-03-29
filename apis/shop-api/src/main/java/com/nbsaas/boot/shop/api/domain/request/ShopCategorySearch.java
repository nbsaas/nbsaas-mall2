package com.nbsaas.boot.shop.api.domain.request;

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
public class ShopCategorySearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "parent.id",operator = Operator.eq)
    private Long parent;


            /**
            * 编码
            **/
            @Search(name = "code",operator = Operator.like)
            private String code;

            /**
            * 
            **/
            @Search(name = "cname",operator = Operator.like)
            private String cname;

            /**
            * 
            **/
            @Search(name = "icon",operator = Operator.like)
            private String icon;

            /**
            * 
            **/
            @Search(name = "py",operator = Operator.like)
            private String py;

            /**
            * 
            **/
            @Search(name = "path",operator = Operator.like)
            private String path;

            /**
            * 
            **/
            @Search(name = "pinyin",operator = Operator.like)
            private String pinyin;

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