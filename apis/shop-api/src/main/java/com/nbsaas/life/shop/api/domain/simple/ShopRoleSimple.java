package com.nbsaas.life.shop.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ShopRoleSimple implements Serializable {

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
                private String name;

            /**
            * 商家id
            **/
                private String shopName;

            /**
            * 主键id
            **/
                private Long id;


}