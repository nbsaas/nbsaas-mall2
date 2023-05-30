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
public class UserOauthConfigSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    /**
     * 程序密钥
     **/
    @Search(name = "appSecret", operator = Operator.like)
    private String appSecret;
    /**
     * java实现类
     **/
    @Search(name = "className", operator = Operator.like)
    private String className;
    /**
     * 程序key
     **/
    @Search(name = "appKey", operator = Operator.like)
    private String appKey;
    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;
    /**
     * 状态
     **/
    @Search(name = "state", operator = Operator.eq)
    private Integer state;
    /**
     * 第三方标识
     **/
    @Search(name = "model", operator = Operator.like)
    private String model;
    /**
     * 第三方登陆名称
     **/
    @Search(name = "name", operator = Operator.like)
    private String name;


}