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
public class ShopRoleRequest implements Serializable,RequestId {

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
            //private String shopNameName;

        /**
        * 主键id
        **/
            private Long id;
}