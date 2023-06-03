package com.nbsaas.life.ad.api.domain.request;

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
public class AdSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    @Search(name = "path", operator = Operator.like)
    private String path;

    /**
     *
     **/
    @Search(name = "bussId", operator = Operator.eq)
    private Long bussId;

    /**
     *
     **/
    @Search(name = "note", operator = Operator.like)
    private String note;

    /**
     *
     **/
    @Search(name = "catalog", operator = Operator.eq)
    private Integer catalog;

    /**
     * 排序号
     **/
    @Search(name = "sortNum", operator = Operator.eq)
    private Integer sortNum;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     *
     **/
    @Search(name = "url", operator = Operator.like)
    private String url;

    /**
     *
     **/
    @Search(name = "title", operator = Operator.like)
    private String title;


}