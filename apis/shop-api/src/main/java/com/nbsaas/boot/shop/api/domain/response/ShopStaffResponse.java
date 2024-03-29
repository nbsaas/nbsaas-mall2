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
public class ShopStaffResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 商家id
        **/
            private Long shop;

        /**
        * 
        **/
            private String phone;

        /**
        * 用户账号id
        **/
            private String staffName;

        /**
        * 
        **/
            private String name;

        /**
        * 商家id
        **/
            private String shopName;

        /**
        * 用户账号id
        **/
            private Long staff;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private String avatar;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 用户登录次数
        **/
            private Integer loginSize;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}