package com.nbsaas.boot.customer.api.domain.request;

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
public class CustomerSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "name",operator = Operator.like)
    private String name;

    @Search(name = "realName",operator = Operator.like)
    private String realName;

    @Search(name = "structure.id",operator = Operator.eq)
    private Long structure;


            /**
            * 用户介绍
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 地址
            **/
            @Search(name = "address",operator = Operator.like)
            private String address;

            /**
            * 用户类型
            **/
            @Search(name = "catalog",operator = Operator.eq)
            private Integer catalog;

            /**
            * 性别
            **/
            @Search(name = "sex",operator = Operator.like)
            private String sex;

            /**
            * 用户头像
            **/
            @Search(name = "avatar",operator = Operator.like)
            private String avatar;

            /**
            * 身份证号码
            **/
            @Search(name = "idNumber",operator = Operator.like)
            private String idNumber;

            /**
            * 生日
            **/
            @Search(name = "birthDate",operator = Operator.like)
            private String birthDate;

            /**
            * 自拍照
            **/
            @Search(name = "selfFile",operator = Operator.like)
            private String selfFile;

            /**
            * 用户登录次数
            **/
            @Search(name = "loginSize",operator = Operator.eq)
            private Integer loginSize;

            /**
            * 身份证前面
            **/
            @Search(name = "frontIdCard",operator = Operator.like)
            private String frontIdCard;

            /**
            * 联系电话
            **/
            @Search(name = "phone",operator = Operator.like)
            private String phone;

            /**
            * 备注
            **/
            @Search(name = "comment",operator = Operator.like)
            private String comment;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 身份证后面
            **/
            @Search(name = "backIdCard",operator = Operator.like)
            private String backIdCard;



}