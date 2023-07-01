package com.nbsaas.life.system.api.domain.request;

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
public class RecordLogSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    @Search(name = "createName", operator = Operator.like)
    private String createName;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     *
     **/
    @Search(name = "app", operator = Operator.like)
    private String app;

    /**
     *
     **/
    @Search(name = "createUser", operator = Operator.eq)
    private Long createUser;

    /**
     *
     **/
    @Search(name = "data", operator = Operator.like)
    private String data;

    /**
     *
     **/
    @Search(name = "title", operator = Operator.like)
    private String title;

    /**
     *
     **/
    @Search(name = "ip", operator = Operator.like)
    private String ip;


}