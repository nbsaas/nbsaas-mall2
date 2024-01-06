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
public class OrderAddressResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Long area;

        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private String address;

        /**
        * 
        **/
            private String consignee;

        /**
        * 
        **/
            private Double lng;

        /**
        * 
        **/
            private Long city;

        /**
        * 
        **/
            private String postalCode;

        /**
        * 
        **/
            private String label;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private Long province;

        /**
        * 
        **/
            private String cityName;

        /**
        * 
        **/
            private String areaName;

        /**
        * 
        **/
            private String phone;

        /**
        * 
        **/
            private String houseNo;

        /**
        * 
        **/
            private String tel;

        /**
        * 
        **/
            private String provinceName;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Double lat;

        /**
        * 
        **/
            private Long order;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}