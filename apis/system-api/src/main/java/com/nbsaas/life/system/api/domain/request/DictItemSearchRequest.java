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
public class DictItemSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     * 排序字段
     **/
    @Search(name = "sortNum", operator = Operator.eq)
    private Integer sortNum;

    /**
     * 键值
     **/
    @Search(name = "dataValue", operator = Operator.like)
    private String dataValue;

    /**
     * 编码
     **/
    @Search(name = "dataCode", operator = Operator.like)
    private String dataCode;


}