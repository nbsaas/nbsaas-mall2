package com.nbsaas.boot.order.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class OrderHotelItemRequest implements Serializable,RequestId {

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
            //private String shopNameName;

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