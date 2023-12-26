package com.nbsaas.boot.promote.api.domain.request;

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
public class CouponRuleSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "name",operator = Operator.like)
    private String name;

    @Search(name = "shop",operator = Operator.eq)
    private Long shop;


            /**
            * 
            **/
            @Search(name = "limitNum",operator = Operator.eq)
            private Integer limitNum;

            /**
            * 
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 
            **/
            @Search(name = "takeawayRate",operator = Operator.eq)
            private Integer takeawayRate;

            /**
            * 
            **/
            @Search(name = "useNum",operator = Operator.eq)
            private Long useNum;

            /**
            * 
            **/
            @Search(name = "logo",operator = Operator.like)
            private String logo;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 
            **/
            @Search(name = "stock",operator = Operator.eq)
            private Integer stock;

            /**
            * 
            **/
            @Search(name = "sendNum",operator = Operator.eq)
            private Long sendNum;

            /**
            * 
            **/
            @Search(name = "useDay",operator = Operator.eq)
            private Integer useDay;



}