package com.nbsaas.life.product.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class ProductSkuResponse  implements Serializable {
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