package com.nbsaas.boot.customer.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class CustomerRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 地址
        **/
            private String address;

        /**
        * 性别
        **/
            private String sex;

        /**
        * 身份证号码
        **/
            private String idNumber;

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