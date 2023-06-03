package com.nbsaas.life.area.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 列表对象
 */
@Data
public class AreaHotSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     * 排序号
     **/
    private Integer sortNum;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 区域id
     **/
    private String areaName;

    /**
     * 区域id
     **/
    private Long area;

    /**
     * 添加时间
     **/
    private Date addDate;


}