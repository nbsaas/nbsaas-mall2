package com.nbsaas.life.ad.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 列表对象
 */
@Data
public class AdSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     *
     **/
    private String path;

    /**
     *
     **/
    private Date beginDate;

    /**
     *
     **/
    private Long bussId;

    /**
     *
     **/
    private String note;

    /**
     *
     **/
    private Integer catalog;

    /**
     * 添加时间
     **/
    private Date addDate;

    /**
     * 排序号
     **/
    private Integer sortNum;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private Long adPosition;

    /**
     *
     **/
    private String adPositionName;

    /**
     *
     **/
    private String url;

    /**
     *
     **/
    private String title;

    /**
     *
     **/
    private Date endDate;


}