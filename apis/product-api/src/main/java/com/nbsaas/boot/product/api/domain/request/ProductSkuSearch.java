package com.nbsaas.boot.product.api.domain.request;

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
public class ProductSkuSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "name",operator = Operator.like)
    private String name;


            /**
            * 
            **/
            @Search(name = "stockNum",operator = Operator.eq)
            private Long stockNum;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 
            **/
            @Search(name = "spec",operator = Operator.like)
            private String spec;



}