package com.nbsaas.life.user.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.life.user.api.domain.enums.SecurityType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class UserPasswordResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 密码
        **/
            private String password;

        /**
        * 加密盐
        **/
            private String salt;

        /**
        * 
        **/
            //枚举
            private SecurityType securityType;

            private String securityTypeName;

        /**
        * 校验次数
        **/
            private Integer checkSize;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 用户id
        **/
            private Long user;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}