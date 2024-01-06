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
public class OrderAddressRequest implements Serializable,RequestId {

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
            //private String cityNameName;

        /**
        * 
        **/
            //private String areaNameName;

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
            //private String provinceNameName;

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