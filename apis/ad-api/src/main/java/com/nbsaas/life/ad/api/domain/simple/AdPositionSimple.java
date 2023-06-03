package com.nbsaas.life.ad.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 列表对象
 */
@Data
public class AdPositionSimple implements Serializable {

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
     *
     **/
    private String name;

    /**
     *
     **/
    private String key;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private Integer height;

    /**
     *
     **/
    private String note;

    /**
     *
     **/
    private Integer width;

    /**
     *
     **/
    private String template;

    /**
     * 添加时间
     **/
    private Date addDate;


}