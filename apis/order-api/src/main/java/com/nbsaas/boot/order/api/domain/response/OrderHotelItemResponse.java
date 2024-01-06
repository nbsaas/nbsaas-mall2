package com.nbsaas.boot.order.api.domain.response;

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
public class OrderHotelItemResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String note;

        /**
        * 商家id
        **/
            private Long shop;

        /**
        * 
        **/
            private String phone;

        /**
        * 
        **/
            private BigDecimal price;

        /**
        * 
        **/
            private String name;

        /**
        * 商家id
        **/
            private String shopName;

        /**
        * 
        **/
            private Date beginTime;

        /**
        * 
        **/
            private Date endTime;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Long order;

}