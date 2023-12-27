package com.nbsaas.boot.product.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.nbsaas.boot.rest.enums.StoreState;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BrandSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "storeState",operator = Operator.eq)
    private StoreState storeState;


            /**
            * 品牌介绍
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 品牌名称
            **/
            @Search(name = "name",operator = Operator.like)
            private String name;

            /**
            * 品牌logo
            **/
            @Search(name = "logo",operator = Operator.like)
            private String logo;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}