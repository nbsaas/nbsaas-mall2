package com.nbsaas.life.area.api.domain.request;

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
public class AreaSearchRequest extends PageRequest implements Serializable {

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
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;
    /**
     * 编码
     **/
    @Search(name = "code", operator = Operator.like)
    private String code;
    /**
     * 左节点
     **/
    @Search(name = "lft", operator = Operator.eq)
    private Integer lft;
    /**
     * 右节点
     **/
    @Search(name = "rgt", operator = Operator.eq)
    private Integer rgt;
    /**
     * 深度
     **/
    @Search(name = "depth", operator = Operator.eq)
    private Integer depth;
    /**
     * 名称
     **/
    @Search(name = "name", operator = Operator.like)
    private String name;
    /**
     * ids
     **/
    @Search(name = "ids", operator = Operator.like)
    private String ids;


}