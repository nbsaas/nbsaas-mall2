package com.nbsaas.boot.shop.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class ShopStaffRoleRequest implements Serializable,RequestId {

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
            //private String shopRoleNameName;

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
            //private String shopNameName;

        /**
        * 主键id
        **/
            private Long id;
}