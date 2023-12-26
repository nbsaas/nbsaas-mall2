package com.nbsaas.life.product.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class ProductSkuRequest implements Serializable,RequestId {

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