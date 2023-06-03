package com.nbsaas.life.system.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

/**
* 列表对象
 */
@Data
public class SequenceSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private Integer increment;

    /**
     *
     **/
    private Date createDate;

    /**
     *
     **/
    private Date updateDate;

    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     *
     **/
    private String name;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private Long currentNum;

    /**
     * 添加时间
     **/
    private Date addDate;


}