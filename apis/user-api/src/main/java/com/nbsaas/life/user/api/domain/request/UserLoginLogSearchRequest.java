package com.nbsaas.life.user.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 搜索bean
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserLoginLogSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 备注
     **/
    @Search(name = "note", operator = Operator.like)
    private String note;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     * 登陆账号
     **/
    @Search(name = "account", operator = Operator.like)
    private String account;

    /**
     * 登录密码
     **/
    @Search(name = "password", operator = Operator.like)
    private String password;

    /**
     * 登录IP
     **/
    @Search(name = "ip", operator = Operator.like)
    private String ip;

    /**
     * 客户端
     **/
    @Search(name = "client", operator = Operator.like)
    private String client;


}