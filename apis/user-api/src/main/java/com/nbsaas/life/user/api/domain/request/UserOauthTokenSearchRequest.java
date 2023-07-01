package com.nbsaas.life.user.api.domain.request;

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
public class UserOauthTokenSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 访问token
            **/
            @Search(name = "access_token",operator = Operator.like)
            private String access_token;

            /**
            * 刷新token
            **/
            @Search(name = "refresh_token",operator = Operator.like)
            private String refresh_token;

            /**
            * 用户openId
            **/
            @Search(name = "openId",operator = Operator.like)
            private String openId;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * token类型
            **/
            @Search(name = "tokenType",operator = Operator.like)
            private String tokenType;

            /**
            * 过期时间
            **/
            @Search(name = "expiresTime",operator = Operator.eq)
            private Long expiresTime;

            /**
            * 登录次数
            **/
            @Search(name = "loginSize",operator = Operator.eq)
            private Integer loginSize;



}