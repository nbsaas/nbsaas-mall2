package com.nbsaas.boot.product.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ProductSkuSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 
            **/
                private Long product;

            /**
            * 
            **/
                private BigDecimal price;

            /**
            * 
            **/
                private String name;

            /**
            * 
            **/
                private Long stockNum;

            /**
            * 
            **/
                private Float discount;

            /**
            * 
            **/
                private BigDecimal mealFee;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 
            **/
                private String spec;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}