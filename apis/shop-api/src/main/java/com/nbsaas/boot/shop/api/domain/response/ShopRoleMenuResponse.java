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
public class ShopRoleMenuResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 角色id
        **/
            private Long role;

        /**
        * 商家id
        **/
            private Long shop;

        /**
        * 商家id
        **/
            private String shopName;

        /**
        * 
        **/
            private String permission;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 菜单id
        **/
            private Long menu;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}