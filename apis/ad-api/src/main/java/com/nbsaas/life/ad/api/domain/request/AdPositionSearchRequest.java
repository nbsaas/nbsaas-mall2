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
public class AdPositionSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    /**
     * 排序号
     **/
    @Search(name = "sortNum", operator = Operator.eq)
    private Integer sortNum;
    /**
     *
     **/
    @Search(name = "name", operator = Operator.like)
    private String name;
    /**
     *
     **/
    @Search(name = "key", operator = Operator.like)
    private String key;
    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;
    /**
     *
     **/
    @Search(name = "height", operator = Operator.eq)
    private Integer height;
    /**
     *
     **/
    @Search(name = "note", operator = Operator.like)
    private String note;
    /**
     *
     **/
    @Search(name = "width", operator = Operator.eq)
    private Integer width;
    /**
     *
     **/
    @Search(name = "template", operator = Operator.like)
    private String template;


}