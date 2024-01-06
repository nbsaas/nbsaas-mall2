package com.nbsaas.boot.order.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class OrderHotelItemSimple implements Serializable {

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