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
public class ShopConfigSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "shop.id",operator = Operator.eq)
    private Long shop;


            /**
            * 配置json数据
            **/
            @Search(name = "configData",operator = Operator.like)
            private String configData;

            /**
            * 配置类标识
            **/
            @Search(name = "className",operator = Operator.like)
            private String className;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}