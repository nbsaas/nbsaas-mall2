package com.nbsaas.boot.common.api.domain.request;

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
public class BillboardItemSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "billboard.id",operator = Operator.eq)
    private Long billboard;

    @Search(name = "name",operator = Operator.like)
    private String name;


            /**
            * 
            **/
            @Search(name = "score",operator = Operator.eq)
            private Integer score;

            /**
            * 
            **/
            @Search(name = "logo",operator = Operator.like)
            private String logo;

            /**
            * 
            **/
            @Search(name = "sortNum",operator = Operator.eq)
            private Integer sortNum;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}