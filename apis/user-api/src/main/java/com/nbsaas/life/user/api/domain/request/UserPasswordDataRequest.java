package com.nbsaas.life.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.life.user.api.domain.enums.SecurityType;
/**
* 请求对象
*/
@Data
public class UserPasswordDataRequest implements Serializable,RequestId {

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
            private SecurityType securityType;

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