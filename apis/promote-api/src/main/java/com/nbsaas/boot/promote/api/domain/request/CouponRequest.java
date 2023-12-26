package com.nbsaas.boot.promote.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class CouponRequest implements Serializable,RequestId {

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
            //private String customerNameName;

        /**
        * 
        **/
            private Long customer;
}