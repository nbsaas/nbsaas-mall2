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
public class SequenceTableSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 
            **/
            @Search(name = "name",operator = Operator.like)
            private String name;

            /**
            * 
            **/
            @Search(name = "step",operator = Operator.eq)
            private Integer step;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.like)
            private String id;

            /**
            * 
            **/
            @Search(name = "value",operator = Operator.eq)
            private Long value;



}