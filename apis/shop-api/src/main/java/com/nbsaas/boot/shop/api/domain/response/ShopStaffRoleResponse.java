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
public class ShopStaffRoleResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 商家id
        **/
            private Long shop;

        /**
        * 店铺用工角色
        **/
            private String shopRoleName;

        /**
        * 店铺用工角色
        **/
            private Long shopRole;

        /**
        * 店铺员工账号
        **/
            private Long shopStaff;

        /**
        * 商家id
        **/
            private String shopName;

        /**
        * 主键id
        **/
            private Long id;

}