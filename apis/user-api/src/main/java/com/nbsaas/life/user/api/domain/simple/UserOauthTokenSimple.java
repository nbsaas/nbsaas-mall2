package com.nbsaas.life.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class UserOauthTokenSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 访问token
            **/
                private String access_token;

            /**
            * 刷新token
            **/
                private String refresh_token;

            /**
            * 用户openId
            **/
                private String openId;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * token类型
            **/
                private String tokenType;

            /**
            * 用户id
            **/
                private Long user;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 过期时间
            **/
                private Long expiresTime;

            /**
            * 登录次数
            **/
                private Integer loginSize;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}