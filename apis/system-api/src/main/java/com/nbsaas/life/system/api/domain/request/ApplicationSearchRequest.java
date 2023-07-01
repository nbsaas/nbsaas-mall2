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
public class ApplicationSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 应用key
     **/
    @Search(name = "appKey", operator = Operator.like)
    private String appKey;

    /**
     * 应用名称
     **/
    @Search(name = "name", operator = Operator.like)
    private String name;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     * 应用介绍
     **/
    @Search(name = "note", operator = Operator.like)
    private String note;


}