package com.nbsaas.boot.shop.api.domain.response;

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
public class ShopCheckInResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Double latitude;

        /**
        * 
        **/
            private String comment;

        /**
        * 
        **/
            private String gps;

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
            private Double longitude;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}