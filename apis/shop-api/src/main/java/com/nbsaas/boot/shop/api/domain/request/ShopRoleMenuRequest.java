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
public class ShopRoleMenuRequest implements Serializable,RequestId {

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
            //private String shopNameName;

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