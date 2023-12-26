package com.nbsaas.boot.promote.api.domain.response;

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
public class CouponResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Date useEndTime;

        /**
        * 
        **/
            private BigDecimal orderAmount;

        /**
        * 
        **/
            private Long shop;

        /**
        * 
        **/
            private Short expireType;

        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private BigDecimal discountAmount;

        /**
        * 
        **/
            private Date useBeginTime;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private String customerName;

        /**
        * 
        **/
            private Long customer;

}