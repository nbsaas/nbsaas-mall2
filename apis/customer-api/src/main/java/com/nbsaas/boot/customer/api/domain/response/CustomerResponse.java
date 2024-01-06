package com.nbsaas.boot.customer.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.rest.enums.DataScope;
            import com.nbsaas.boot.rest.enums.State;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class CustomerResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 用户介绍
        **/
            private String note;

        /**
        * 地址
        **/
            private String address;

        /**
        * 用户类型
        **/
            private Integer catalog;

        /**
        * 所在组织
        **/
            private String structureName;

        /**
        * 性别
        **/
            private String sex;

        /**
        * 用户头像
        **/
            private String avatar;

        /**
        * 身份证号码
        **/
            private String idNumber;

        /**
        * 
        **/
            //枚举
            private DataScope dataScope;

            private String dataScopeName;

        /**
        * 生日
        **/
            private String birthDate;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 自拍照
        **/
            private String selfFile;

        /**
        * 
        **/
            private Integer auditState;

            private String auditStateName;

        /**
        * 所在组织
        **/
            private Long structure;

        /**
        * 用户登录次数
        **/
            private Integer loginSize;

        /**
        * 真实姓名
        **/
            private String realName;

        /**
        * 身份证前面
        **/
            private String frontIdCard;

        /**
        * 联系电话
        **/
            private String phone;

        /**
        * 客户名称
        **/
            private String name;

        /**
        * 备注
        **/
            private String comment;

        /**
        * 
        **/
            //枚举
            private State state;

            private String stateName;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 身份证后面
        **/
            private String backIdCard;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}