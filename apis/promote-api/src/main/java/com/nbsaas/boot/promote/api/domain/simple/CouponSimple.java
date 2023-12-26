package com.nbsaas.boot.promote.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class CouponSimple implements Serializable {

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