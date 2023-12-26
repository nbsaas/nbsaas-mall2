package com.nbsaas.boot.shop.api.domain.request;

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
public class ShopStaffSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "shop.id",operator = Operator.eq)
    private Long shop;

    @Search(name = "user.name",operator = Operator.like)
    private String name;

    @Search(name = "user.phone",operator = Operator.like)
    private String phone;


            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 用户登录次数
            **/
            @Search(name = "loginSize",operator = Operator.eq)
            private Integer loginSize;



}