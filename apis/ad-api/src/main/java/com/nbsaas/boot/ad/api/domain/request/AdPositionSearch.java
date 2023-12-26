package com.nbsaas.boot.ad.api.domain.request;

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
public class AdPositionSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "name",operator = Operator.like)
    private String name;


            /**
            * 模板
            **/
            @Search(name = "template",operator = Operator.like)
            private String template;

            /**
            * 描述
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 宽度
            **/
            @Search(name = "width",operator = Operator.eq)
            private Integer width;

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
            * 标识
            **/
            @Search(name = "key",operator = Operator.like)
            private String key;

            /**
            * 高度
            **/
            @Search(name = "height",operator = Operator.eq)
            private Integer height;



}