package com.nbsaas.boot.order.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderAddressSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "province.id",operator = Operator.eq)
    private Long province;

    @Search(name = "city.id",operator = Operator.eq)
    private Long city;

    @Search(name = "area.id",operator = Operator.eq)
    private Long area;

    @Search(name = "consignee",operator = Operator.like)
    private String consignee;

    @Search(name = "phone",operator = Operator.like)
    private String phone;


            /**
            * 
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 
            **/
            @Search(name = "address",operator = Operator.like)
            private String address;

            /**
            * 
            **/
            @Search(name = "postalCode",operator = Operator.like)
            private String postalCode;

            /**
            * 
            **/
            @Search(name = "label",operator = Operator.like)
            private String label;

            /**
            * 
            **/
            @Search(name = "houseNo",operator = Operator.like)
            private String houseNo;

            /**
            * 
            **/
            @Search(name = "tel",operator = Operator.like)
            private String tel;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}