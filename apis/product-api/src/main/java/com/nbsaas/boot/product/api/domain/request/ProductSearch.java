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
public class ProductSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "name",operator = Operator.like)
    private String name;

    @Search(name = "storeState",operator = Operator.eq)
    private StoreState storeState;


            /**
            * 
            **/
            @Search(name = "summary",operator = Operator.like)
            private String summary;

            /**
            * 
            **/
            @Search(name = "thumbnail",operator = Operator.like)
            private String thumbnail;

            /**
            * 
            **/
            @Search(name = "shop",operator = Operator.eq)
            private Long shop;

            /**
            * 
            **/
            @Search(name = "barCode",operator = Operator.like)
            private String barCode;

            /**
            * 
            **/
            @Search(name = "stockNum",operator = Operator.eq)
            private Long stockNum;

            /**
            * 
            **/
            @Search(name = "realStock",operator = Operator.eq)
            private Long realStock;

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



}